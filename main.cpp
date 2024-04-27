#include <iostream>
#include <vector>
#include <string>
#include <ctime>

class SecurityOfficer {
public:
    std::string name;
    std::string designation;
    std::vector<std::string> responsibilities;

    SecurityOfficer(std::string n, std::string d, std::vector<std::string> r)
        : name(n), designation(d), responsibilities(r) {}
};

class Gate {
public:
    int gateNumber;
    std::string location;

    Gate(int num, std::string loc) : gateNumber(num), location(loc) {}
};

class VisitorRecord {
public:
    SecurityOfficer officer;
    time_t dateOfVisit;
    std::string visitorDetails;
    std::string destination;
    std::string purposeOfVisit;
    std::string modeOfTravel;
    std::string report;
    Gate gateUsedToExit;

    VisitorRecord(SecurityOfficer o, std::string details, std::string dest,
                  std::string purpose, std::string travel, Gate exitGate)
        : officer(o), dateOfVisit(time(nullptr)), visitorDetails(details),
          destination(dest), purposeOfVisit(purpose), modeOfTravel(travel),
          gateUsedToExit(exitGate) {}

    void addReport(std::string rep) {
        report = rep;
    }

    void indicatePurpose(std::string purpose) {
        purposeOfVisit = purpose;
    }
};

class VisitorsBook {
public:
    std::vector<VisitorRecord> records;

    void addRecord(const VisitorRecord& record) {
        records.push_back(record);
    }

    void generateReport() {
        // Implement report generation logic here
    }
};

int main() {
    SecurityOfficer officer("John Doe", "Security Officer", {"Checking IDs", "Issuing passes"});
    Gate mainGate(1, "Main Entrance");
    VisitorsBook visitorsBook;

    // Example Usage:
    VisitorRecord visitorRecord(officer, "John Smith", "Admin Office", "Official", "Car", mainGate);
    visitorRecord.addReport("Visited for a meeting with the Dean.");
    visitorsBook.addRecord(visitorRecord);

    // Perform other operations and use other functionalities as needed.

    return 0;
}
//It was hectic converting this code so don't forget to show some love by starring this repository.