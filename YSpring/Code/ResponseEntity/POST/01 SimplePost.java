@RestController
@RequestMapping(value = "module/")
---------------------------------------
@RequestMapping(value = "/contract", method = RequestMethod.POST)
    public ResponseEntity<Object> create_Contract(@RequestBody Contract_EO contractBody){
        return contract_so.create_Contract(contractBody);
    }
---------------------------------------------------------------------------------------------------------------------
      public ResponseEntity<Object> create_Contract(Contract_EO contractBody) {
        long totProcEndTime = System.currentTimeMillis();
        Contract_EO ls=contract_rp.save(contractBody);
        Long totProcStartTime = System.currentTimeMillis();
        System.out.println("total time taken for proc execution for all item :: " + (totProcEndTime - totProcStartTime) + " ms");
        return ResponseEntity.ok(ls);
    }
---------------------------------------------------------------------------------------------------------------------
    @Repository
public interface Contract_RP extends JpaRepository<Contract_EO ,BigDecimal> {
    
}
---------------------------------------------------------------------------------------------------------------------

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
