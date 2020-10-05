package org.ygba.youthgobudget.community_wishes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import org.ygba.youthgobudget.R;
import org.ygba.youthgobudget.data.community_wishes.CommunityWish;
import org.ygba.youthgobudget.dialogs.DistrictPickerActivity;
import org.ygba.youthgobudget.dialogs.SubCountyPickerActivity;

public class CommunityWishesActivity extends AppCompatActivity implements  AdapterView.OnItemSelectedListener {
    private   final int DISTRICT_NAME_REQUESTER_CODE = 1;
    private   final int SUB_COUNTY_NAME_REQUEST_CODE = 2;
    private  final int QUESTION_2_DATE_RECEIVED_1_REQUEST_CODE = 3;
    private  final int  QUESTION_2_DATE_WITHDRAWN_1_REQUEST_CODE = 4;
    private  final int  QUESTION_2_DATE_RECEIVED_2_REQUEST_CODE = 5;
    private  final int  QUESTION_2_DATE_WITHDRAWN_2_REQUEST_CODE = 6;
    private  final int  QUESTION_4_DATE_WITHDRAWN_5_REQUEST_CODE = 8;
    private final int QUESTION_4_DATE_WITHDRAWN_4_REQUEST_CODE = 9;
    private final int QUESTION_4_DATE_WITHDRAWN_3_REQUEST_CODE = 10;
    private final int QUESTION_4_DATE_WITHDRAWN_2_REQUEST_CODE = 11;
    private final int QUESTION_4_DATE_WITHDRAWN_1_REQUEST_CODE = 12;
    private final int DISPLAY_SUCCESS_MESSAGE_ACTIVITY = 13;
    private int districtId = 0;
    RadioGroup question1RadioGroup;
    Spinner quarterSpinner;
    Spinner financialSpinner;
    Spinner sectorSpinner;

    EditText financialYear;
    TextView districtText;

    EditText villageEditText;
    EditText parishTextEdit;
    TextView divisionEditText;
    EditText agentFullNameEditText;
    EditText agentTelephoneEditText;
    EditText agentNumberEditText;

    private final String[] quarterList = {"I", "II", "III", "IV", "V", "VI", "VII"};
    private final String[] financialYearList = {"2021/22", "2020/21", "2019/20"};
    private final String[] sectorList = {"Agriculture Sector", "Health Sector", "Education Sector"};
    private String selectedQuarter;
    private String selectedFinancialYear;
    private String selectedSector = sectorList[1];

    RadioGroup agricultureRadioGroup;
    RadioGroup healthSectorRadioGroup;
    RadioGroup educationRadioGroup;
    private CommunityWishesActivityViewModel communityWishesActivityViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_wish);
        initViews();
        communityWishesActivityViewModel = new ViewModelProvider(this).get(CommunityWishesActivityViewModel.class);
    }

    private void initViews() {
        quarterSpinner = findViewById(R.id.region_spinner);
        ArrayAdapter<String> aa=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, quarterList);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        quarterSpinner.setAdapter(aa);
        quarterSpinner.setOnItemSelectedListener(this);

        financialSpinner = findViewById(R.id.financial_year_spinner);
        ArrayAdapter<String> fa=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, financialYearList);
        fa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        financialSpinner.setAdapter(fa);
        financialSpinner.setOnItemSelectedListener(this);

        sectorSpinner = findViewById(R.id.sector_spinner);
        ArrayAdapter<String> sa=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sectorList);
        sa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sectorSpinner.setAdapter(sa);
        sectorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedSector = sectorList[position];
                if (selectedSector.equals(sectorList[0])) {
                    educationRadioGroup.setVisibility(View.GONE);
                    agricultureRadioGroup.setVisibility(View.VISIBLE);
                    healthSectorRadioGroup.setVisibility(View.GONE);
                } else if (selectedSector.equals(sectorList[1])) {
                    healthSectorRadioGroup.setVisibility(View.VISIBLE);
                    agricultureRadioGroup.setVisibility(View.GONE);
                    educationRadioGroup.setVisibility(View.GONE);
                } else if(selectedSector.equals(sectorList[2])){
                    healthSectorRadioGroup.setVisibility(View.GONE);
                    educationRadioGroup.setVisibility(View.VISIBLE);
                    agricultureRadioGroup.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        districtText = findViewById(R.id.district_text_edit);
        villageEditText = findViewById(R.id.village_text_edit);
        parishTextEdit = findViewById(R.id.parish_text_edit);
        divisionEditText = findViewById(R.id.division_text_edit);
        agentFullNameEditText = findViewById(R.id.ygb_agent_name_edit_view);
        agentTelephoneEditText = findViewById(R.id.ygb_agent_tel_edit_view);
        agentNumberEditText = findViewById(R.id.ygb_agent_no_edit_view);

        // listeners
        districtText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CommunityWishesActivity.this, DistrictPickerActivity.class);
                startActivityForResult(intent, DISTRICT_NAME_REQUESTER_CODE);
            }
        });

        divisionEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (districtId == 0) {
                    divisionEditText.setError("Please Set District Continue");
                } else {
                    Intent intent = new Intent(CommunityWishesActivity.this, SubCountyPickerActivity.class);
                    startActivityForResult(intent, SUB_COUNTY_NAME_REQUEST_CODE);
                }
            }
        });

        agricultureRadioGroup = findViewById(R.id.agriculture_sector_radio_group);
        healthSectorRadioGroup = findViewById(R.id.health_sector_radio_group);
        educationRadioGroup = findViewById(R.id.education_sector_radio_group);

        findViewById(R.id.saved_form_data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommunityWish communityWish = new CommunityWish(
                        "Central",
                        "Masaka",
                        "Agriculture",
                        "Kimanya",
                        selectedFinancialYear,
                        "Education",
                        "There must be enough books"
                );
                communityWishesActivityViewModel.saveCommunityWish(communityWish);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        if (view.getId() == R.id.financial_year_spinner) {
            selectedFinancialYear = financialYearList[position];
        } else if (view.getId() == R.id.region_spinner) {
            selectedQuarter = quarterList[position];
        } else if (view.getId() == R.id.sector_spinner) {
            selectedSector = sectorList[position];
            if (position == 1) {
                agricultureRadioGroup.setVisibility(View.VISIBLE);
            }
            agricultureRadioGroup.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (data != null) {
                if (requestCode == DISTRICT_NAME_REQUESTER_CODE) {
                    districtText.setText(data.getStringExtra(DistrictPickerActivity.DISTRICT_NAME));
                    districtId = data.getIntExtra(DistrictPickerActivity.DISTRICT_ID, 0);
                } else if (requestCode == SUB_COUNTY_NAME_REQUEST_CODE) {
                    divisionEditText.setText(data.getStringExtra(SubCountyPickerActivity.SUB_COUNTY_NAME));
                }
            }
        }

        if (requestCode == DISPLAY_SUCCESS_MESSAGE_ACTIVITY ) {
            clearForm();
        }
    }

    private void clearForm() {
        selectedQuarter = "";
        selectedQuarter = "";
        villageEditText.setText("");
        parishTextEdit.setText("");
        parishTextEdit.setText("");
        agentFullNameEditText.setText("");
        agentTelephoneEditText.setText("");
        agentNumberEditText.setText("");
    }
}
