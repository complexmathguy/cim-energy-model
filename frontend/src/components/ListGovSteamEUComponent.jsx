import React, { Component } from 'react'
import GovSteamEUService from '../services/GovSteamEUService'

class ListGovSteamEUComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govSteamEUs: []
        }
        this.addGovSteamEU = this.addGovSteamEU.bind(this);
        this.editGovSteamEU = this.editGovSteamEU.bind(this);
        this.deleteGovSteamEU = this.deleteGovSteamEU.bind(this);
    }

    deleteGovSteamEU(id){
        GovSteamEUService.deleteGovSteamEU(id).then( res => {
            this.setState({govSteamEUs: this.state.govSteamEUs.filter(govSteamEU => govSteamEU.govSteamEUId !== id)});
        });
    }
    viewGovSteamEU(id){
        this.props.history.push(`/view-govSteamEU/${id}`);
    }
    editGovSteamEU(id){
        this.props.history.push(`/add-govSteamEU/${id}`);
    }

    componentDidMount(){
        GovSteamEUService.getGovSteamEUs().then((res) => {
            this.setState({ govSteamEUs: res.data});
        });
    }

    addGovSteamEU(){
        this.props.history.push('/add-govSteamEU/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovSteamEU List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovSteamEU}> Add GovSteamEU</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Chc </th>
                                    <th> Cho </th>
                                    <th> Cic </th>
                                    <th> Cio </th>
                                    <th> Db1 </th>
                                    <th> Db2 </th>
                                    <th> Hhpmax </th>
                                    <th> Ke </th>
                                    <th> Kfcor </th>
                                    <th> Khp </th>
                                    <th> Klp </th>
                                    <th> Kwcor </th>
                                    <th> Mwbase </th>
                                    <th> Pmax </th>
                                    <th> Prhmax </th>
                                    <th> Simx </th>
                                    <th> Tb </th>
                                    <th> Tdp </th>
                                    <th> Ten </th>
                                    <th> Tf </th>
                                    <th> Tfp </th>
                                    <th> Thp </th>
                                    <th> Tip </th>
                                    <th> Tlp </th>
                                    <th> Tp </th>
                                    <th> Trh </th>
                                    <th> Tvhp </th>
                                    <th> Tvip </th>
                                    <th> Tw </th>
                                    <th> Wfmax </th>
                                    <th> Wfmin </th>
                                    <th> Wmax1 </th>
                                    <th> Wmax2 </th>
                                    <th> Wwmax </th>
                                    <th> Wwmin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.govSteamEUs.map(
                                        govSteamEU => 
                                        <tr key = {govSteamEU.govSteamEUId}>
                                             <td> { govSteamEU.chc } </td>
                                             <td> { govSteamEU.cho } </td>
                                             <td> { govSteamEU.cic } </td>
                                             <td> { govSteamEU.cio } </td>
                                             <td> { govSteamEU.db1 } </td>
                                             <td> { govSteamEU.db2 } </td>
                                             <td> { govSteamEU.hhpmax } </td>
                                             <td> { govSteamEU.ke } </td>
                                             <td> { govSteamEU.kfcor } </td>
                                             <td> { govSteamEU.khp } </td>
                                             <td> { govSteamEU.klp } </td>
                                             <td> { govSteamEU.kwcor } </td>
                                             <td> { govSteamEU.mwbase } </td>
                                             <td> { govSteamEU.pmax } </td>
                                             <td> { govSteamEU.prhmax } </td>
                                             <td> { govSteamEU.simx } </td>
                                             <td> { govSteamEU.tb } </td>
                                             <td> { govSteamEU.tdp } </td>
                                             <td> { govSteamEU.ten } </td>
                                             <td> { govSteamEU.tf } </td>
                                             <td> { govSteamEU.tfp } </td>
                                             <td> { govSteamEU.thp } </td>
                                             <td> { govSteamEU.tip } </td>
                                             <td> { govSteamEU.tlp } </td>
                                             <td> { govSteamEU.tp } </td>
                                             <td> { govSteamEU.trh } </td>
                                             <td> { govSteamEU.tvhp } </td>
                                             <td> { govSteamEU.tvip } </td>
                                             <td> { govSteamEU.tw } </td>
                                             <td> { govSteamEU.wfmax } </td>
                                             <td> { govSteamEU.wfmin } </td>
                                             <td> { govSteamEU.wmax1 } </td>
                                             <td> { govSteamEU.wmax2 } </td>
                                             <td> { govSteamEU.wwmax } </td>
                                             <td> { govSteamEU.wwmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editGovSteamEU(govSteamEU.govSteamEUId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovSteamEU(govSteamEU.govSteamEUId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovSteamEU(govSteamEU.govSteamEUId)} className="btn btn-info btn-sm">View </button>
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

export default ListGovSteamEUComponent
