import React, { Component } from 'react'
import GovHydroWEHService from '../services/GovHydroWEHService'

class ListGovHydroWEHComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govHydroWEHs: []
        }
        this.addGovHydroWEH = this.addGovHydroWEH.bind(this);
        this.editGovHydroWEH = this.editGovHydroWEH.bind(this);
        this.deleteGovHydroWEH = this.deleteGovHydroWEH.bind(this);
    }

    deleteGovHydroWEH(id){
        GovHydroWEHService.deleteGovHydroWEH(id).then( res => {
            this.setState({govHydroWEHs: this.state.govHydroWEHs.filter(govHydroWEH => govHydroWEH.govHydroWEHId !== id)});
        });
    }
    viewGovHydroWEH(id){
        this.props.history.push(`/view-govHydroWEH/${id}`);
    }
    editGovHydroWEH(id){
        this.props.history.push(`/add-govHydroWEH/${id}`);
    }

    componentDidMount(){
        GovHydroWEHService.getGovHydroWEHs().then((res) => {
            this.setState({ govHydroWEHs: res.data});
        });
    }

    addGovHydroWEH(){
        this.props.history.push('/add-govHydroWEH/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovHydroWEH List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovHydroWEH}> Add GovHydroWEH</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Db </th>
                                    <th> Dicn </th>
                                    <th> Dpv </th>
                                    <th> Dturb </th>
                                    <th> FeedbackSignal </th>
                                    <th> Fl1 </th>
                                    <th> Fl2 </th>
                                    <th> Fl3 </th>
                                    <th> Fl4 </th>
                                    <th> Fl5 </th>
                                    <th> Fp1 </th>
                                    <th> Fp10 </th>
                                    <th> Fp2 </th>
                                    <th> Fp3 </th>
                                    <th> Fp4 </th>
                                    <th> Fp5 </th>
                                    <th> Fp6 </th>
                                    <th> Fp7 </th>
                                    <th> Fp8 </th>
                                    <th> Fp9 </th>
                                    <th> Gmax </th>
                                    <th> Gmin </th>
                                    <th> Gtmxcl </th>
                                    <th> Gtmxop </th>
                                    <th> Gv1 </th>
                                    <th> Gv2 </th>
                                    <th> Gv3 </th>
                                    <th> Gv4 </th>
                                    <th> Gv5 </th>
                                    <th> Kd </th>
                                    <th> Ki </th>
                                    <th> Kp </th>
                                    <th> Mwbase </th>
                                    <th> Pmss1 </th>
                                    <th> Pmss10 </th>
                                    <th> Pmss2 </th>
                                    <th> Pmss3 </th>
                                    <th> Pmss4 </th>
                                    <th> Pmss5 </th>
                                    <th> Pmss6 </th>
                                    <th> Pmss7 </th>
                                    <th> Pmss8 </th>
                                    <th> Pmss9 </th>
                                    <th> Rpg </th>
                                    <th> Rpp </th>
                                    <th> Td </th>
                                    <th> Tdv </th>
                                    <th> Tg </th>
                                    <th> Tp </th>
                                    <th> Tpe </th>
                                    <th> Tw </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.govHydroWEHs.map(
                                        govHydroWEH => 
                                        <tr key = {govHydroWEH.govHydroWEHId}>
                                             <td> { govHydroWEH.db } </td>
                                             <td> { govHydroWEH.dicn } </td>
                                             <td> { govHydroWEH.dpv } </td>
                                             <td> { govHydroWEH.dturb } </td>
                                             <td> { govHydroWEH.feedbackSignal } </td>
                                             <td> { govHydroWEH.fl1 } </td>
                                             <td> { govHydroWEH.fl2 } </td>
                                             <td> { govHydroWEH.fl3 } </td>
                                             <td> { govHydroWEH.fl4 } </td>
                                             <td> { govHydroWEH.fl5 } </td>
                                             <td> { govHydroWEH.fp1 } </td>
                                             <td> { govHydroWEH.fp10 } </td>
                                             <td> { govHydroWEH.fp2 } </td>
                                             <td> { govHydroWEH.fp3 } </td>
                                             <td> { govHydroWEH.fp4 } </td>
                                             <td> { govHydroWEH.fp5 } </td>
                                             <td> { govHydroWEH.fp6 } </td>
                                             <td> { govHydroWEH.fp7 } </td>
                                             <td> { govHydroWEH.fp8 } </td>
                                             <td> { govHydroWEH.fp9 } </td>
                                             <td> { govHydroWEH.gmax } </td>
                                             <td> { govHydroWEH.gmin } </td>
                                             <td> { govHydroWEH.gtmxcl } </td>
                                             <td> { govHydroWEH.gtmxop } </td>
                                             <td> { govHydroWEH.gv1 } </td>
                                             <td> { govHydroWEH.gv2 } </td>
                                             <td> { govHydroWEH.gv3 } </td>
                                             <td> { govHydroWEH.gv4 } </td>
                                             <td> { govHydroWEH.gv5 } </td>
                                             <td> { govHydroWEH.kd } </td>
                                             <td> { govHydroWEH.ki } </td>
                                             <td> { govHydroWEH.kp } </td>
                                             <td> { govHydroWEH.mwbase } </td>
                                             <td> { govHydroWEH.pmss1 } </td>
                                             <td> { govHydroWEH.pmss10 } </td>
                                             <td> { govHydroWEH.pmss2 } </td>
                                             <td> { govHydroWEH.pmss3 } </td>
                                             <td> { govHydroWEH.pmss4 } </td>
                                             <td> { govHydroWEH.pmss5 } </td>
                                             <td> { govHydroWEH.pmss6 } </td>
                                             <td> { govHydroWEH.pmss7 } </td>
                                             <td> { govHydroWEH.pmss8 } </td>
                                             <td> { govHydroWEH.pmss9 } </td>
                                             <td> { govHydroWEH.rpg } </td>
                                             <td> { govHydroWEH.rpp } </td>
                                             <td> { govHydroWEH.td } </td>
                                             <td> { govHydroWEH.tdv } </td>
                                             <td> { govHydroWEH.tg } </td>
                                             <td> { govHydroWEH.tp } </td>
                                             <td> { govHydroWEH.tpe } </td>
                                             <td> { govHydroWEH.tw } </td>
                                             <td>
                                                 <button onClick={ () => this.editGovHydroWEH(govHydroWEH.govHydroWEHId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovHydroWEH(govHydroWEH.govHydroWEHId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovHydroWEH(govHydroWEH.govHydroWEHId)} className="btn btn-info btn-sm">View </button>
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

export default ListGovHydroWEHComponent
