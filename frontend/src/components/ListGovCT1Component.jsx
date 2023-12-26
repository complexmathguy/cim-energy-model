import React, { Component } from 'react'
import GovCT1Service from '../services/GovCT1Service'

class ListGovCT1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govCT1s: []
        }
        this.addGovCT1 = this.addGovCT1.bind(this);
        this.editGovCT1 = this.editGovCT1.bind(this);
        this.deleteGovCT1 = this.deleteGovCT1.bind(this);
    }

    deleteGovCT1(id){
        GovCT1Service.deleteGovCT1(id).then( res => {
            this.setState({govCT1s: this.state.govCT1s.filter(govCT1 => govCT1.govCT1Id !== id)});
        });
    }
    viewGovCT1(id){
        this.props.history.push(`/view-govCT1/${id}`);
    }
    editGovCT1(id){
        this.props.history.push(`/add-govCT1/${id}`);
    }

    componentDidMount(){
        GovCT1Service.getGovCT1s().then((res) => {
            this.setState({ govCT1s: res.data});
        });
    }

    addGovCT1(){
        this.props.history.push('/add-govCT1/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovCT1 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovCT1}> Add GovCT1</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Aset </th>
                                    <th> Db </th>
                                    <th> Dm </th>
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
                                    this.state.govCT1s.map(
                                        govCT1 => 
                                        <tr key = {govCT1.govCT1Id}>
                                             <td> { govCT1.aset } </td>
                                             <td> { govCT1.db } </td>
                                             <td> { govCT1.dm } </td>
                                             <td> { govCT1.ka } </td>
                                             <td> { govCT1.kdgov } </td>
                                             <td> { govCT1.kigov } </td>
                                             <td> { govCT1.kiload } </td>
                                             <td> { govCT1.kimw } </td>
                                             <td> { govCT1.kpgov } </td>
                                             <td> { govCT1.kpload } </td>
                                             <td> { govCT1.kturb } </td>
                                             <td> { govCT1.ldref } </td>
                                             <td> { govCT1.maxerr } </td>
                                             <td> { govCT1.minerr } </td>
                                             <td> { govCT1.mwbase } </td>
                                             <td> { govCT1.r } </td>
                                             <td> { govCT1.rclose } </td>
                                             <td> { govCT1.rdown } </td>
                                             <td> { govCT1.ropen } </td>
                                             <td> { govCT1.rselect } </td>
                                             <td> { govCT1.rup } </td>
                                             <td> { govCT1.ta } </td>
                                             <td> { govCT1.tact } </td>
                                             <td> { govCT1.tb } </td>
                                             <td> { govCT1.tc } </td>
                                             <td> { govCT1.tdgov } </td>
                                             <td> { govCT1.teng } </td>
                                             <td> { govCT1.tfload } </td>
                                             <td> { govCT1.tpelec } </td>
                                             <td> { govCT1.tsa } </td>
                                             <td> { govCT1.tsb } </td>
                                             <td> { govCT1.vmax } </td>
                                             <td> { govCT1.vmin } </td>
                                             <td> { govCT1.wfnl } </td>
                                             <td> { govCT1.wfspd } </td>
                                             <td>
                                                 <button onClick={ () => this.editGovCT1(govCT1.govCT1Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovCT1(govCT1.govCT1Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovCT1(govCT1.govCT1Id)} className="btn btn-info btn-sm">View </button>
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

export default ListGovCT1Component
