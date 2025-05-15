CREATE TABLE IF NOT EXISTS doctors (
id SERIAL PRIMARY KEY,
first_name VARCHAR(50),
last_name VARCHAR(50),
specialty VARCHAR(100),
phone_number VARCHAR(15),
email VARCHAR(100) UNIQUE,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE  IF NOT EXISTS patients (
id SERIAL PRIMARY KEY,
first_name VARCHAR(50),
last_name VARCHAR(50),
date_of_birth DATE,
gender VARCHAR(10),
phone_number VARCHAR(15),
email VARCHAR(100) UNIQUE,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE  IF NOT EXISTS appointments (
id SERIAL PRIMARY KEY,
doctor_id INT REFERENCES doctors(id) ON DELETE CASCADE,
patient_id INT REFERENCES patients(id) ON DELETE CASCADE,
appointment_date TIMESTAMP,
status VARCHAR(20),
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS medical_records (
id SERIAL PRIMARY KEY,
patient_id INT REFERENCES patients(id) ON DELETE CASCADE,
diagnosis TEXT,
treatment TEXT,
doctor_id INT REFERENCES doctors(id) ON DELETE CASCADE,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE  IF NOT EXISTS doctor_patient (
doctor_id INT,
patient_id INT,
PRIMARY KEY (doctor_id, patient_id),
FOREIGN KEY (doctor_id) REFERENCES doctors(id) ON DELETE CASCADE,
FOREIGN KEY (patient_id) REFERENCES patients(id) ON DELETE CASCADE
);

	