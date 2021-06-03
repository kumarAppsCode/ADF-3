    @RequestMapping(value = "temp", method = RequestMethod.GET)
    public String getData(@RequestParam(value = "nam", required = false) String name){
           String results=null;
           if(name!=null){
               results="hello"+name;
           }else{
               results="hello";
           }
           return results;
    }
***************************************************************************************************
@RequestMapping(value = "/contract" ,method = RequestMethod.GET)
    public ResponseEntity<Object> getall_contract(){
        return searchContractRO_so.getall_contract();
    }

public ResponseEntity<Object> getall_contract() {
    List<SearchContractRO_EO> ls = searchContractRO_rp.findAll();
    return ResponseEntity.ok().body(ls);            
}

------------------------------------
public interface SearchContractRO_RP extends JpaRepository<SearchContractRO_EO ,BigDecimal>  {}
------------------------------------
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "XXSM_CONTRACT_HEADER_V")
public class SearchContractRO_EO {
    
@Id
@Column(name = "CONTRACT_ID")    
public BigDecimal contractId;
@Column(name = "CONTRACT_NUMBER")    
public String contractNumber;
@Column(name = "CONTRACT_NAME")
public String contractName;
@Column(name = "CONTRACT_DATE")
@JsonFormat(pattern="dd-MM-YYYY")
public Date contractDate;
@Column(name = "CONTRACT_START_DATE")
@JsonFormat(pattern="dd-MM-YYYY")
public Date contractStartDate;
@JsonFormat(pattern="dd-MM-YYYY")
@Column(name = "CONTRACT_END_DATE")
public Date contractEndDate;
------------------------------------
By Id: ***************************************************************************************************    
    @RequestMapping(value = "/contract/{Contract_Id}", method = RequestMethod.GET)
    public ResponseEntity<Object> get_contract(
                                        @PathVariable(name = "Contract_Id", required = false) BigDecimal Contract_Id){
        return searchContractRO_so.findByContractId(Contract_Id);
    }
****************************************************************************************	
public ResponseEntity<Object> findByContractId(BigDecimal contract_Id) {
    if(contract_Id==null){
        List<SearchContractRO_EO> ls = searchContractRO_rp.findAll();
        return ResponseEntity.ok().body(ls);            
    }else{
        Optional<SearchContractRO_EO> ls = searchContractRO_rp.findById(contract_Id);
        return ResponseEntity.ok().body(ls);
    }
}	
****************************************************************************************	
