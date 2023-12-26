import React, { Component } from 'react'
import ExcIEEEAC2AService from '../services/ExcIEEEAC2AService'

class ListExcIEEEAC2AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excIEEEAC2As: []
        }
        this.addExcIEEEAC2A = this.addExcIEEEAC2A.bind(this);
        this.editExcIEEEAC2A = this.editExcIEEEAC2A.bind(this);
        this.deleteExcIEEEAC2A = this.deleteExcIEEEAC2A.bind(this);
    }

    deleteExcIEEEAC2A(id){
        ExcIEEEAC2AService.deleteExcIEEEAC2A(id).then( res => {
            this.setState({excIEEEAC2As: this.state.excIEEEAC2As.filter(excIEEEAC2A => excIEEEAC2A.excIEEEAC2AId !== id)});
        });
    }
    viewExcIEEEAC2A(id){
        this.props.history.push(`/view-excIEEEAC2A/${id}`);
    }
    editExcIEEEAC2A(id){
        this.props.history.push(`/add-excIEEEAC2A/${id}`);
    }

    componentDidMount(){
        ExcIEEEAC2AService.getExcIEEEAC2As().then((res) => {
            this.setState({ excIEEEAC2As: res.data});
        });
    }

    addExcIEEEAC2A(){
        this.props.history.push('/add-excIEEEAC2A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcIEEEAC2A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcIEEEAC2A}> Add ExcIEEEAC2A</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Ka </th>
                                    <th> Kb </th>
                                    <th> Kc </th>
                                    <th> Kd </th>
                                    <th> Ke </th>
                                    <th> Kf </th>
                                    <th> Kh </th>
                                    <th> Seve1 </th>
                                    <th> Seve2 </th>
                                    <th> Ta </th>
                                    <th> Tb </th>
                                    <th> Tc </th>
                                    <th> Te </th>
                                    <th> Tf </th>
                                    <th> Vamax </th>
                                    <th> Vamin </th>
                                    <th> Ve1 </th>
                                    <th> Ve2 </th>
                                    <th> Vfemax </th>
                                    <th> Vrmax </th>
                                    <th> Vrmin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excIEEEAC2As.map(
                                        excIEEEAC2A => 
                                        <tr key = {excIEEEAC2A.excIEEEAC2AId}>
                                             <td> { excIEEEAC2A.ka } </td>
                                             <td> { excIEEEAC2A.kb } </td>
                                             <td> { excIEEEAC2A.kc } </td>
                                             <td> { excIEEEAC2A.kd } </td>
                                             <td> { excIEEEAC2A.ke } </td>
                                             <td> { excIEEEAC2A.kf } </td>
                                             <td> { excIEEEAC2A.kh } </td>
                                             <td> { excIEEEAC2A.seve1 } </td>
                                             <td> { excIEEEAC2A.seve2 } </td>
                                             <td> { excIEEEAC2A.ta } </td>
                                             <td> { excIEEEAC2A.tb } </td>
                                             <td> { excIEEEAC2A.tc } </td>
                                             <td> { excIEEEAC2A.te } </td>
                                             <td> { excIEEEAC2A.tf } </td>
                                             <td> { excIEEEAC2A.vamax } </td>
                                             <td> { excIEEEAC2A.vamin } </td>
                                             <td> { excIEEEAC2A.ve1 } </td>
                                             <td> { excIEEEAC2A.ve2 } </td>
                                             <td> { excIEEEAC2A.vfemax } </td>
                                             <td> { excIEEEAC2A.vrmax } </td>
                                             <td> { excIEEEAC2A.vrmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcIEEEAC2A(excIEEEAC2A.excIEEEAC2AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcIEEEAC2A(excIEEEAC2A.excIEEEAC2AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcIEEEAC2A(excIEEEAC2A.excIEEEAC2AId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcIEEEAC2AComponent
