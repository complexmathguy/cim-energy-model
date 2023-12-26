import React, { Component } from 'react'
import ExcPICService from '../services/ExcPICService'

class ListExcPICComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excPICs: []
        }
        this.addExcPIC = this.addExcPIC.bind(this);
        this.editExcPIC = this.editExcPIC.bind(this);
        this.deleteExcPIC = this.deleteExcPIC.bind(this);
    }

    deleteExcPIC(id){
        ExcPICService.deleteExcPIC(id).then( res => {
            this.setState({excPICs: this.state.excPICs.filter(excPIC => excPIC.excPICId !== id)});
        });
    }
    viewExcPIC(id){
        this.props.history.push(`/view-excPIC/${id}`);
    }
    editExcPIC(id){
        this.props.history.push(`/add-excPIC/${id}`);
    }

    componentDidMount(){
        ExcPICService.getExcPICs().then((res) => {
            this.setState({ excPICs: res.data});
        });
    }

    addExcPIC(){
        this.props.history.push('/add-excPIC/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcPIC List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcPIC}> Add ExcPIC</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> E1 </th>
                                    <th> E2 </th>
                                    <th> Efdmax </th>
                                    <th> Efdmin </th>
                                    <th> Ka </th>
                                    <th> Kc </th>
                                    <th> Ke </th>
                                    <th> Kf </th>
                                    <th> Ki </th>
                                    <th> Kp </th>
                                    <th> Se1 </th>
                                    <th> Se2 </th>
                                    <th> Ta1 </th>
                                    <th> Ta2 </th>
                                    <th> Ta3 </th>
                                    <th> Ta4 </th>
                                    <th> Te </th>
                                    <th> Tf1 </th>
                                    <th> Tf2 </th>
                                    <th> Vr1 </th>
                                    <th> Vr2 </th>
                                    <th> Vrmax </th>
                                    <th> Vrmin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excPICs.map(
                                        excPIC => 
                                        <tr key = {excPIC.excPICId}>
                                             <td> { excPIC.e1 } </td>
                                             <td> { excPIC.e2 } </td>
                                             <td> { excPIC.efdmax } </td>
                                             <td> { excPIC.efdmin } </td>
                                             <td> { excPIC.ka } </td>
                                             <td> { excPIC.kc } </td>
                                             <td> { excPIC.ke } </td>
                                             <td> { excPIC.kf } </td>
                                             <td> { excPIC.ki } </td>
                                             <td> { excPIC.kp } </td>
                                             <td> { excPIC.se1 } </td>
                                             <td> { excPIC.se2 } </td>
                                             <td> { excPIC.ta1 } </td>
                                             <td> { excPIC.ta2 } </td>
                                             <td> { excPIC.ta3 } </td>
                                             <td> { excPIC.ta4 } </td>
                                             <td> { excPIC.te } </td>
                                             <td> { excPIC.tf1 } </td>
                                             <td> { excPIC.tf2 } </td>
                                             <td> { excPIC.vr1 } </td>
                                             <td> { excPIC.vr2 } </td>
                                             <td> { excPIC.vrmax } </td>
                                             <td> { excPIC.vrmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcPIC(excPIC.excPICId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcPIC(excPIC.excPICId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcPIC(excPIC.excPICId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcPICComponent
