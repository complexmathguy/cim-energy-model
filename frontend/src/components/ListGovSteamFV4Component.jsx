import React, { Component } from 'react'
import GovSteamFV4Service from '../services/GovSteamFV4Service'

class ListGovSteamFV4Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govSteamFV4s: []
        }
        this.addGovSteamFV4 = this.addGovSteamFV4.bind(this);
        this.editGovSteamFV4 = this.editGovSteamFV4.bind(this);
        this.deleteGovSteamFV4 = this.deleteGovSteamFV4.bind(this);
    }

    deleteGovSteamFV4(id){
        GovSteamFV4Service.deleteGovSteamFV4(id).then( res => {
            this.setState({govSteamFV4s: this.state.govSteamFV4s.filter(govSteamFV4 => govSteamFV4.govSteamFV4Id !== id)});
        });
    }
    viewGovSteamFV4(id){
        this.props.history.push(`/view-govSteamFV4/${id}`);
    }
    editGovSteamFV4(id){
        this.props.history.push(`/add-govSteamFV4/${id}`);
    }

    componentDidMount(){
        GovSteamFV4Service.getGovSteamFV4s().then((res) => {
            this.setState({ govSteamFV4s: res.data});
        });
    }

    addGovSteamFV4(){
        this.props.history.push('/add-govSteamFV4/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovSteamFV4 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovSteamFV4}> Add GovSteamFV4</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Cpsmn </th>
                                    <th> Cpsmx </th>
                                    <th> Crmn </th>
                                    <th> Crmx </th>
                                    <th> Kdc </th>
                                    <th> Kf1 </th>
                                    <th> Kf3 </th>
                                    <th> Khp </th>
                                    <th> Kic </th>
                                    <th> Kip </th>
                                    <th> Kit </th>
                                    <th> Kmp1 </th>
                                    <th> Kmp2 </th>
                                    <th> Kpc </th>
                                    <th> Kpp </th>
                                    <th> Kpt </th>
                                    <th> Krc </th>
                                    <th> Ksh </th>
                                    <th> Lpi </th>
                                    <th> Lps </th>
                                    <th> Mnef </th>
                                    <th> Mxef </th>
                                    <th> Pr1 </th>
                                    <th> Pr2 </th>
                                    <th> Psmn </th>
                                    <th> Rsmimn </th>
                                    <th> Rsmimx </th>
                                    <th> Rvgmn </th>
                                    <th> Rvgmx </th>
                                    <th> Srmn </th>
                                    <th> Srmx </th>
                                    <th> Srsmp </th>
                                    <th> Svmn </th>
                                    <th> Svmx </th>
                                    <th> Ta </th>
                                    <th> Tam </th>
                                    <th> Tc </th>
                                    <th> Tcm </th>
                                    <th> Tdc </th>
                                    <th> Tf1 </th>
                                    <th> Tf2 </th>
                                    <th> Thp </th>
                                    <th> Tmp </th>
                                    <th> Trh </th>
                                    <th> Tv </th>
                                    <th> Ty </th>
                                    <th> Y </th>
                                    <th> Yhpmn </th>
                                    <th> Yhpmx </th>
                                    <th> Ympmn </th>
                                    <th> Ympmx </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.govSteamFV4s.map(
                                        govSteamFV4 => 
                                        <tr key = {govSteamFV4.govSteamFV4Id}>
                                             <td> { govSteamFV4.cpsmn } </td>
                                             <td> { govSteamFV4.cpsmx } </td>
                                             <td> { govSteamFV4.crmn } </td>
                                             <td> { govSteamFV4.crmx } </td>
                                             <td> { govSteamFV4.kdc } </td>
                                             <td> { govSteamFV4.kf1 } </td>
                                             <td> { govSteamFV4.kf3 } </td>
                                             <td> { govSteamFV4.khp } </td>
                                             <td> { govSteamFV4.kic } </td>
                                             <td> { govSteamFV4.kip } </td>
                                             <td> { govSteamFV4.kit } </td>
                                             <td> { govSteamFV4.kmp1 } </td>
                                             <td> { govSteamFV4.kmp2 } </td>
                                             <td> { govSteamFV4.kpc } </td>
                                             <td> { govSteamFV4.kpp } </td>
                                             <td> { govSteamFV4.kpt } </td>
                                             <td> { govSteamFV4.krc } </td>
                                             <td> { govSteamFV4.ksh } </td>
                                             <td> { govSteamFV4.lpi } </td>
                                             <td> { govSteamFV4.lps } </td>
                                             <td> { govSteamFV4.mnef } </td>
                                             <td> { govSteamFV4.mxef } </td>
                                             <td> { govSteamFV4.pr1 } </td>
                                             <td> { govSteamFV4.pr2 } </td>
                                             <td> { govSteamFV4.psmn } </td>
                                             <td> { govSteamFV4.rsmimn } </td>
                                             <td> { govSteamFV4.rsmimx } </td>
                                             <td> { govSteamFV4.rvgmn } </td>
                                             <td> { govSteamFV4.rvgmx } </td>
                                             <td> { govSteamFV4.srmn } </td>
                                             <td> { govSteamFV4.srmx } </td>
                                             <td> { govSteamFV4.srsmp } </td>
                                             <td> { govSteamFV4.svmn } </td>
                                             <td> { govSteamFV4.svmx } </td>
                                             <td> { govSteamFV4.ta } </td>
                                             <td> { govSteamFV4.tam } </td>
                                             <td> { govSteamFV4.tc } </td>
                                             <td> { govSteamFV4.tcm } </td>
                                             <td> { govSteamFV4.tdc } </td>
                                             <td> { govSteamFV4.tf1 } </td>
                                             <td> { govSteamFV4.tf2 } </td>
                                             <td> { govSteamFV4.thp } </td>
                                             <td> { govSteamFV4.tmp } </td>
                                             <td> { govSteamFV4.trh } </td>
                                             <td> { govSteamFV4.tv } </td>
                                             <td> { govSteamFV4.ty } </td>
                                             <td> { govSteamFV4.y } </td>
                                             <td> { govSteamFV4.yhpmn } </td>
                                             <td> { govSteamFV4.yhpmx } </td>
                                             <td> { govSteamFV4.ympmn } </td>
                                             <td> { govSteamFV4.ympmx } </td>
                                             <td>
                                                 <button onClick={ () => this.editGovSteamFV4(govSteamFV4.govSteamFV4Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovSteamFV4(govSteamFV4.govSteamFV4Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovSteamFV4(govSteamFV4.govSteamFV4Id)} className="btn btn-info btn-sm">View </button>
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

            </div>
        )
    }
}

export default ListGovSteamFV4Component
