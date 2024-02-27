package com.task.hrms.services;

import com.task.hrms.model.*;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
@Service
public class ExcelService {


    private static <T> void createSheetForModel(Workbook workbook, String sheetName, Class<T> clazz) {
        Sheet sheet = workbook.createSheet(sheetName);
        Row headerRow = sheet.createRow(0);

        if (clazz.equals(Employee.class)) {
            String[] headers = {"id", "panNumber", "oldEmployeeCode", "dateOfAppoinment", "bioMetricId", "salutation", "department", "designation", "unit", "firstName", "middleName", "lastName", "employeeEligibleFor", "isGazetted", "isUnderGratuityAct", "isEnable"};
            createHeaders(headerRow, headers);
        } else if (clazz.equals(Address.class)) {
            String[] headers = {"id", "addressType", "address", "country", "state", "district", "city", "pincode", "allAddressAreSame", "addressOwner", "isEnable"};
            createHeaders(headerRow, headers);
        } else if (clazz.equals(Contact.class)) {
            String[] headers = {"id", "workPhone", "extention", "workMobile", "homePhone", "homeMobile", "corporateEmail", "personalEmail", "secondaryEmail", "isEnable"};
            createHeaders(headerRow, headers);
        }
        else if (clazz.equals(Emergency.class)) {
            String[] headers = {"ID", "Priority", "First Name", "Middle Name", "Last Name", "Relation", "Phone No", "Mobile No", "Email", "Address", "Is Enable"};;
            createHeaders(headerRow, headers);
        }
        else if (clazz.equals(Family.class)) {
            String[] headers = {"ID", "First Name", "Middle Name", "Last Name", "Relation", "Date of Birth", "Gender", "Marital Status", "Occupation", "Contact Details", "Nationality", "Is Nominee", "Is Dependent", "Is Residing With", "Contact In Emergency", "Is Physically Disabled", "Address", "Is Enable"};
            createHeaders(headerRow, headers);
        }
        else if (clazz.equals(Health.class)) {
            String[] headers = {"ID", "Height", "Weight", "Blood Group", "Identification Mark 1", "Identification Mark 2", "Is Handicapped", "Is Enable"};
            createHeaders(headerRow, headers);
        }
        else if (clazz.equals(Nominee.class)) {
            String[] headers = {"ID", "Priority", "First Name", "Middle Name", "Last Name", "Relation",
                    "Gender", "Date of Birth", "UID Number", "PAN Number", "Contact Number",
                    "Nominee Invalid Condition", "Is Enable"};
            createHeaders(headerRow, headers);
        }
        else if (clazz.equals(Job.class)) {
            String[] headers = {"ID", "Employment Type", "Employment Category", "Employment SubType", "Status",
                    "Notice Period", "Employee Grade", "Probation Duration", "Probation Start Date",
                    "Duties and Responsibilities", "Insurance Start Group", "Insurance With Effective From",
                    "Place of Position", "Branch Name", "Work Location", "Is Enable", "Designation",
                    "Date of Posting", "Group When Posting", "Post Order Number", "Date of Posting Order",
                    "Pay Configuration", "Scale", "Scale Value", "Grade Pay", "Recruitment Category",
                    "Recruitment Type", "Shift", "Weekly Off With Effective From", "Weekly Off"};

            createHeaders(headerRow, headers);
        }

        else if (clazz.equals(ReportingOfficer.class)) {
            String[] headers = {"ID", "Start Date", "End Date", "DDO", "DH", "HO", "HOD", "Authorization Date", "Note", "Is Enable"};


            createHeaders(headerRow, headers);
        }

        else if (clazz.equals(PreviousEmployment.class)) {
            String[] headers = {"ID", "From Date", "To Date", "Company Name", "Service Type", "Position", "CTC",
                    "Responsibilities", "Reason of Separation", "HR Contact Person", "Phone Number",
                    "Mobile Number", "Email", "Website", "Address", "Remark", "Is Enable"};


            createHeaders(headerRow, headers);
        }

        else if (clazz.equals(Qualification.class)) {
            String[] headers = {"ID", "Qualification", "Mode of Study", "University", "Passing Month", "Board",
                    "Passing Year", "Duration", "Major", "Percentage", "Grade", "Percentile",
                    "GPA Score", "Remark", "Institute Address", "Is Enable"};


            createHeaders(headerRow, headers);
        }

        else if (clazz.equals(Personal.class)) {
            String[] headers = {"ID", "Gender", "Marriage Status", "Date of Birth", "Date of Marriage",
                    "Birth Place", "Community Category", "UID No", "GPF AC No", "Religion",
                    "Caste", "Community Category Ref", "Nationality", "Postel Life Insurance No",
                    "Hobbies", "Bank Name", "Bank Branch", "Bank AC No", "IFSC Code", "BSR Code",
                    "Passport No", "Date of Expiry", "Visa Detail", "Driving Licence No",
                    "Vehicle Type", "Valid Upto", "Issued State", "Detail of Vehicle Provider",
                    "Is Government Vehicle Provider", "Is Used For On Duty", "Is Resident of Other Country",
                    "Is Disciplinary Proceeding", "Additional Info", "Migration Date of India",
                    "Country", "Other Country Address", "Is Enable"};


            createHeaders(headerRow, headers);
        }


    }

    private static void createHeaders(Row headerRow, String[] headers) {
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }
    }

    public Workbook createExcel() throws IOException {
       Workbook workbook = WorkbookFactory.create(true);

        createSheetForModel(workbook, "Employee", Employee.class);
        createSheetForModel(workbook, "Address", Address.class);
        createSheetForModel(workbook, "Contact", Contact.class);
        createSheetForModel(workbook, "Emergency", Emergency.class);
        createSheetForModel(workbook, "Family", Family.class);
        createSheetForModel(workbook, "Health", Health.class);
        createSheetForModel(workbook, "Job", Job.class);
        createSheetForModel(workbook, "ReportingOfficer", ReportingOfficer.class);
        createSheetForModel(workbook, "PreviousEmployment", PreviousEmployment.class);
        createSheetForModel(workbook, "Qualification", Qualification.class);
        createSheetForModel(workbook, "Personal", Personal.class);


        return workbook;
    }
}
