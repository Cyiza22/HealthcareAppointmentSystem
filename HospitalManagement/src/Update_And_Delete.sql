SELECT p.*
FROM appointments a
JOIN patients p ON a.patient_id = p.id
WHERE a.doctor_id = 1; 

SELECT *
FROM medical_records
WHERE patient_id = 2;

SELECT d.id, d.first_name, d.last_name, COUNT(a.id) AS total_appointments
FROM doctors d
LEFT JOIN appointments a ON d.id = a.doctor_id
GROUP BY d.id, d.first_name, d.last_name
ORDER BY total_appointments DESC;

SELECT d.id, d.first_name, d.last_name, COUNT(dp.patient_id) AS total_patients
FROM doctors d
LEFT JOIN doctor_patient dp ON d.id = dp.doctor_id
GROUP BY d.id, d.first_name, d.last_name
ORDER BY total_patients DESC;

UPDATE appointments
SET status = 'Completed'
WHERE id = 1;

DELETE FROM patients
WHERE id = 2;  

SELECT d.id, d.first_name, d.last_name, COUNT(dp.patient_id) AS total_patients
FROM doctors d
JOIN doctor_patient dp ON d.id = dp.doctor_id
GROUP BY d.id, d.first_name, d.last_name
HAVING COUNT(dp.patient_id) > 5;

SELECT p.id, p.first_name, p.last_name, COUNT(m.id) AS diagnosis_count
FROM patients p
JOIN medical_records m ON p.id = m.patient_id
GROUP BY p.id, p.first_name, p.last_name
HAVING COUNT(m.id) > 1;

SELECT 
    DATE_TRUNC('month', appointment_date) AS month,
    COUNT(*) AS total_appointments
FROM appointments
GROUP BY DATE_TRUNC('month', appointment_date)
ORDER BY month;

ALTER TABLE doctors
ADD CONSTRAINT unique_doctor_email UNIQUE (email);

ALTER TABLE patients
ADD CONSTRAINT unique_patient_email UNIQUE (email);

CREATE INDEX idx_appointment_date ON appointments(appointment_date);
