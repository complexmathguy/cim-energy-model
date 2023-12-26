import React, { Component } from 'react'
import GovCT2Service from '../services/GovCT2Service'

class ListGovCT2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govCT2s: []
        }
        this.addGovCT2 = this.addGovCT2.bind(this);
        this.editGovCT2 = this.editGovCT2.bind(this);
        this.deleteGovCT2 = this.deleteGovCT2.bind(this);
    }

    deleteGovCT2(id){
        GovCT2Service.deleteGovCT2(id).then( res => {
            this.setState({govCT2s: this.state.govCT2s.filter(govCT2 => govCT2.govCT2Id !== id)});
        });
    }
    viewGovCT2(id){
        this.props.history.push(`/view-govCT2/${id}`);
    }
    editGovCT2(id){
        this.props.history.push(`/add-govCT2/${id}`);
    }

    componentDidMount(){
        GovCT2Service.getGovCT2s().then((res) => {
            this.setState({ govCT2s: res.data});
        });
    }

    addGovCT2(){
        this.props.history.push('/add-govCT2/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovCT2 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovCT2}> Add GovCT2</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Aset </th>
                                    <th> Db </th>
                                    <th> Dm </th>
                                    <th> Flim1 </th>
                                    <th> Flim10 </th>
                                    <th> Flim2 </th>
                                    <th> Flim3 </th>
                                    <th> Flim4 </th>
                                    <th> Flim5 </th>
                                    <th> Flim6 </th>
                                    <th> Flim7 </th>
                                    <th> Flim8 </th>
                                    <th> Flim9 </th>
                                    <th> Ka </th>
                                    <th> Kdgov </th>
                                    <th> Kigov </th>
                                    <th> Kiload </th>
                                    <th> Kimw </th>
                                    <th> Kpgov </th>
                                    <th> Kpload </th>
                                    <th> Kturb </th>
                                    <th> Ldref </th>
                                    <th> Maxerr </th>
                                    <th> Minerr </th>
                                    <th> Mwbase </th>
                                    <th> Plim1 </th>
                                    <th> Plim10 </th>
                                    <th> Plim2 </th>
                                    <th> Plim3 </th>
                                    <th> Plim4 </th>
                                    <th> Plim5 </th>
                                    <th> Plim6 </th>
                                    <th> Plim7 </th>
                                    <th> Plim8 </th>
                                    <th> Plim9 </th>
                                    <th> Prate </th>
                                    <th> R </th>
                                    <th> Rclose </th>
                                    <th> Rdown </th>
                                    <th> Ropen </th>
                                    <th> Rselect </th>
                                    <th> Rup </th>
                                    <th> Ta </th>
                                    <th> Tact </th>
                                    <th> Tb </th>
                                    <th> Tc </th>
                                    <th> Tdgov </th>
                                    <th> Teng </th>
                                    <th> Tfload </th>
                                    <th> Tpelec </th>
                                    <th> Tsa </th>
                                    <th> Tsb </th>
                                    <th> Vmax </th>
                                    <th> Vmin </th>
                                    <th> Wfnl </th>
                                    <th> Wfspd </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.govCT2s.map(
                                        govCT2 => 
                                        <tr key = {govCT2.govCT2Id}>
                                             <td> { govCT2.aset } </td>
                                             <td> { govCT2.db } </td>
                                             <td> { govCT2.dm } </td>
                                             <td> { govCT2.flim1 } </td>
                                             <td> { govCT2.flim10 } </td>
                                             <td> { govCT2.flim2 } </td>
                                             <td> { govCT2.flim3 } </td>
                                             <td> { govCT2.flim4 } </td>
                                             <td> { govCT2.flim5 } </td>
                                             <td> { govCT2.flim6 } </td>
                                             <td> { govCT2.flim7 } </td>
                                             <td> { govCT2.flim8 } </td>
                                             <td> { govCT2.flim9 } </td>
                                             <td> { govCT2.ka } </td>
                                             <td> { govCT2.kdgov } </td>
                                             <td> { govCT2.kigov } </td>
                                             <td> { govCT2.kiload } </td>
                                             <td> { govCT2.kimw } </td>
                                             <td> { govCT2.kpgov } </td>
                                             <td> { govCT2.kpload } </td>
                                             <td> { govCT2.kturb } </td>
                                             <td> { govCT2.ldref } </td>
                                             <td> { govCT2.maxerr } </td>
                                             <td> { govCT2.minerr } </td>
                                             <td> { govCT2.mwbase } </td>
                                             <td> { govCT2.plim1 } </td>
                                             <td> { govCT2.plim10 } </td>
                                             <td> { govCT2.plim2 } </td>
                                             <td> { govCT2.plim3 } </td>
                                             <td> { govCT2.plim4 } </td>
                                             <td> { govCT2.plim5 } </td>
                                             <td> { govCT2.plim6 } </td>
                                             <td> { govCT2.plim7 } </td>
                                             <td> { govCT2.plim8 } </td>
                                             <td> { govCT2.plim9 } </td>
                                             <td> { govCT2.prate } </td>
                                             <td> { govCT2.r } </td>
                                             <td> { govCT2.rclose } </td>
                                             <td> { govCT2.rdown } </td>
                                             <td> { govCT2.ropen } </td>
                                             <td> { govCT2.rselect } </td>
                                             <td> { govCT2.rup } </td>
                                             <td> { govCT2.ta } </td>
                                             <td> { govCT2.tact } </td>
                                             <td> { govCT2.tb } </td>
                                             <td> { govCT2.tc } </td>
                                             <td> { govCT2.tdgov } </td>
                                             <td> { govCT2.teng } </td>
                                             <td> { govCT2.tfload } </td>
                                             <td> { govCT2.tpelec } </td>
                                             <td> { govCT2.tsa } </td>
                                             <td> { govCT2.tsb } </td>
                                             <td> { govCT2.vmax } </td>
                                             <td> { govCT2.vmin } </td>
                                             <td> { govCT2.wfnl } </td>
                                             <td> { govCT2.wfspd } </td>
                                             <td>
                                                 <button onClick={ () => this.editGovCT2(govCT2.govCT2Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovCT2(govCT2.govCT2Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovCT2(govCT2.govCT2Id)} className="btn btn-info btn-sm">View </button>
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

export default ListGovCT2Component
