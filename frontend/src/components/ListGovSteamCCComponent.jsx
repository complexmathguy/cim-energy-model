import React, { Component } from 'react'
import GovSteamCCService from '../services/GovSteamCCService'

class ListGovSteamCCComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govSteamCCs: []
        }
        this.addGovSteamCC = this.addGovSteamCC.bind(this);
        this.editGovSteamCC = this.editGovSteamCC.bind(this);
        this.deleteGovSteamCC = this.deleteGovSteamCC.bind(this);
    }

    deleteGovSteamCC(id){
        GovSteamCCService.deleteGovSteamCC(id).then( res => {
            this.setState({govSteamCCs: this.state.govSteamCCs.filter(govSteamCC => govSteamCC.govSteamCCId !== id)});
        });
    }
    viewGovSteamCC(id){
        this.props.history.push(`/view-govSteamCC/${id}`);
    }
    editGovSteamCC(id){
        this.props.history.push(`/add-govSteamCC/${id}`);
    }

    componentDidMount(){
        GovSteamCCService.getGovSteamCCs().then((res) => {
            this.setState({ govSteamCCs: res.data});
        });
    }

    addGovSteamCC(){
        this.props.history.push('/add-govSteamCC/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovSteamCC List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovSteamCC}> Add GovSteamCC</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Dhp </th>
                                    <th> Dlp </th>
                                    <th> Fhp </th>
                                    <th> Flp </th>
                                    <th> Mwbase </th>
                                    <th> Pmaxhp </th>
                                    <th> Pmaxlp </th>
                                    <th> Rhp </th>
                                    <th> Rlp </th>
                                    <th> T1hp </th>
                                    <th> T1lp </th>
                                    <th> T3hp </th>
                                    <th> T3lp </th>
                                    <th> T4hp </th>
                                    <th> T4lp </th>
                                    <th> T5hp </th>
                                    <th> T5lp </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.govSteamCCs.map(
                                        govSteamCC => 
                                        <tr key = {govSteamCC.govSteamCCId}>
                                             <td> { govSteamCC.dhp } </td>
                                             <td> { govSteamCC.dlp } </td>
                                             <td> { govSteamCC.fhp } </td>
                                             <td> { govSteamCC.flp } </td>
                                             <td> { govSteamCC.mwbase } </td>
                                             <td> { govSteamCC.pmaxhp } </td>
                                             <td> { govSteamCC.pmaxlp } </td>
                                             <td> { govSteamCC.rhp } </td>
                                             <td> { govSteamCC.rlp } </td>
                                             <td> { govSteamCC.t1hp } </td>
                                             <td> { govSteamCC.t1lp } </td>
                                             <td> { govSteamCC.t3hp } </td>
                                             <td> { govSteamCC.t3lp } </td>
                                             <td> { govSteamCC.t4hp } </td>
                                             <td> { govSteamCC.t4lp } </td>
                                             <td> { govSteamCC.t5hp } </td>
                                             <td> { govSteamCC.t5lp } </td>
                                             <td>
                                                 <button onClick={ () => this.editGovSteamCC(govSteamCC.govSteamCCId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovSteamCC(govSteamCC.govSteamCCId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovSteamCC(govSteamCC.govSteamCCId)} className="btn btn-info btn-sm">View </button>
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

export default ListGovSteamCCComponent
