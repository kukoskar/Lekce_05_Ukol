package com.engeto.plants;

import java.time.LocalDate;

public class Plant {
    private String name;
    private String notes;
    private LocalDate planted;
    private LocalDate watering;
    private int freqOfWatering;

    public Plant(String name, String notes, LocalDate planted, LocalDate watering, int freqOfWatering) throws PlantException {
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        this.watering = watering;
        this.freqOfWatering = freqOfWatering;
        checkFreqOfWatering(freqOfWatering);
        checkWatering(watering);

    }

    public Plant(String name, LocalDate planted, int freqOfWatering) throws PlantException {
        this(name, "", planted, LocalDate.now(), freqOfWatering);
    }

    public Plant(String name) throws PlantException{
        this(name, "", LocalDate.now(), LocalDate.now(), 7);
    }

    private void checkWatering(LocalDate planted) throws PlantException {
        if (watering.isBefore(planted)) {
            throw new PlantException("Datum nesmí být menší než den posledního zalití " +
                    " (zadal jsi zasazení: " + planted + " a poslední zalití " + watering + " )");
        }
    }

    private void checkFreqOfWatering(int freqOfWatering) throws PlantException {
        if (freqOfWatering < 1) {
            throw new PlantException("Počet dní nesmí být menší než 1" +
                    " (zadal jsi : " + freqOfWatering + " )");
        }
        setFreqOfWatering(freqOfWatering);
    }

    public String getWateringInfo() {
        return "Jsem " + name + ". Naposled mě zalili: " + watering + ". Zalij mě za " + freqOfWatering + " dní."
     ;}

    public String getAllPlantInfo() {
        return "Jmenuji se " + name + ". " + notes + "" + "Zasazená " + planted + "." + " Naposled mě zaliti " + watering
                + "." + " Prosím zalévat každých " + freqOfWatering + " dni. ";
    }

    public String getName()
    {
      return name;
    }

    public void setName(String name)
    {
      this.name = name;
    }

    public String getNotes()
    {
       return notes;
    }

    public void setNotes(String notes)
    {
      this.notes = notes;
    }

    public LocalDate getPlanted()
    {
      return planted;
    }

    public void setPlanted(LocalDate planted)
    {
      this.planted = planted;
    }

    public LocalDate getWatering()
    {
      return watering;
    }


    public void setWatering(LocalDate watering) throws PlantException{
        if (watering.isBefore(planted)) {
            throw new PlantException("Datum nesmí být menší než den posledního zalití " +
                    " (zadal jsi zasazení: " + planted + " a poslední zalití " + watering + " )");
        }
    }

    public int getFreqOfWatering()
    {
      return freqOfWatering;
    }

    public void setFreqOfWatering(int freqOfWatering) throws PlantException {
        if (freqOfWatering < 1) {
            throw new PlantException("Počet dní nesmí být menší než 1" +
                    " (zadal jsi : " + freqOfWatering + " )");
        }
    }
}
