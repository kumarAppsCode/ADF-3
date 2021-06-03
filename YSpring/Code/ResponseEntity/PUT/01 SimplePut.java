    @RequestMapping(value = "/contract/{contract_id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> update_Contract(
                        @RequestBody Contract_EO contractBody,
                        @PathVariable(name = "contract_id") BigDecimal contract_id
                                                 ){
        return contract_so.update_Contract(contractBody, contract_id);
    }
-----------------------------------------------------------------------------------
        public ResponseEntity<Object> update_Contract(Contract_EO contractBody, BigDecimal contract_id) {
        
        Optional<Contract_EO> isVal = contract_rp.findById(contract_id);
            if(isVal.isPresent()){
                Contract_EO ls=contract_rp.save(contractBody);
                return ResponseEntity.ok(ls);
            }else{
                return ResponseEntity.ok("No Data Found");
            }
    }
-----------------------------------------------------------------------------------
    @Repository
public interface Contract_RP extends JpaRepository<Contract_EO ,BigDecimal> {
    
}
-----------------------------------------------------------------------------------

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "XXSM_CONTRACT_HEADER")
// @JsonInclude(JsonInclude.Include.NON_NULL)
public class Contract_EO {

@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contract_hdr_id_seq")
@SequenceGenerator(name = "contract_hdr_id_seq",sequenceName = "contract_hdr_id_s", allocationSize = 1)
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
public Date  contractStartDate;
@Column(name = "CONTRACT_END_DATE")
@JsonFormat(pattern="dd-MM-YYYY")
public Date  contractEndDate;
