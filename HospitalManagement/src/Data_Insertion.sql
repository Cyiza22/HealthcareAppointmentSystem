INSERT INTO doctors (first_name, last_name, specialty, phone_number, email)
VALUES 
('John', 'Kamali', 'Cardiology', '1234567890', 'john.kamali@example.com'),
('Chanelle', 'Brown', 'Pediatrics', '9876543210', 'chanelle.brown@example.com'),
('Mark', 'white', 'Dermatology', '1112223333', 'mark.white@example.com');

INSERT INTO patients (first_name, last_name, date_of_birth, gender, phone_number, email)
VALUES 
('Alice', 'Mutoni', '1985-04-23', 'Female', '5551112222', 'alice.mutoni@example.com'),
('Bob', 'Williams', '1992-10-15', 'Male', '5552223333', 'bob.williams@example.com'),
('Anne', 'Orange', '2001-01-10', 'Female', '5553334444', 'anne.orange@example.com');

INSERT INTO appointments (doctor_id, patient_id, appointment_date, status)
VALUES
(1, 1, '2025-05-15', 'Scheduled'),
(2, 2, '2025-05-16', 'Completed'),
(3, 3, '2025-05-17', 'Canceled'),
(1, 2, '2025-05-18', 'Scheduled');

INSERT INTO medical_records (patient_id, diagnosis, treatment, doctor_id)
VALUES
(1, 'High blood pressure', 'Medication A', 1),
(2, 'Flu', 'Rest and fluids', 2),
(3, 'Acne', 'Cream X', 3),
(2, 'Allergy', 'Antihistamines', 1);

INSERT INTO doctor_patient (doctor_id, patient_id)
VALUES
(1, 1),
(2, 2),
(3, 3),
(1, 2); 



