<?php
header("Content-Type: text/Calendar");
// Give the file a name and force download
header("Content-Disposition: inline; filename=calendar.ics");

echo "BEGIN:VCALENDAR\n";
echo "VERSION:2.0\n";
echo "PRODID:-//hacksw/handcal//NONSGML v1.0//EN\n";
echo "BEGIN:VEVENT\n";
echo "DTSTART:20090714T170000Z\n";
echo "DTEND:20090715T035959Z\n";
echo "SUMMARY:Bastille Day Party\n";
echo "END:VEVENT\n";
echo "END:VCALENDAR\n";
?>