    @RequestMapping(value = "/contracts" ,method = RequestMethod.GET)
    public ResponseEntity<Object> getall_contracts(){
        return contract_so.getall_contracts();
    }
------------------------------------------------------------------
        public ResponseEntity<Object> getall_contracts() {
        List<Contract_EO> ls = contract_rp.findAll();
        return ResponseEntity.ok().body(ls);
    }
------------------------------------------------------------------
@Repository
public interface Contract_RP extends JpaRepository<Contract_EO ,BigDecimal> {
    
}
------------------------------------------------------------------
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
