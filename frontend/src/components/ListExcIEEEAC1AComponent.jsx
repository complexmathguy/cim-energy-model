import React, { Component } from 'react'
import ExcIEEEAC1AService from '../services/ExcIEEEAC1AService'

class ListExcIEEEAC1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excIEEEAC1As: []
        }
        this.addExcIEEEAC1A = this.addExcIEEEAC1A.bind(this);
        this.editExcIEEEAC1A = this.editExcIEEEAC1A.bind(this);
        this.deleteExcIEEEAC1A = this.deleteExcIEEEAC1A.bind(this);
    }

    deleteExcIEEEAC1A(id){
        ExcIEEEAC1AService.deleteExcIEEEAC1A(id).then( res => {
            this.setState({excIEEEAC1As: this.state.excIEEEAC1As.filter(excIEEEAC1A => excIEEEAC1A.excIEEEAC1AId !== id)});
        });
    }
    viewExcIEEEAC1A(id){
        this.props.history.push(`/view-excIEEEAC1A/${id}`);
    }
    editExcIEEEAC1A(id){
        this.props.history.push(`/add-excIEEEAC1A/${id}`);
    }

    componentDidMount(){
        ExcIEEEAC1AService.getExcIEEEAC1As().then((res) => {
            this.setState({ excIEEEAC1As: res.data});
        });
    }

    addExcIEEEAC1A(){
        this.props.history.push('/add-excIEEEAC1A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcIEEEAC1A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcIEEEAC1A}> Add ExcIEEEAC1A</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Ka </th>
                                    <th> Kc </th>
                                    <th> Kd </th>
                                    <th> Ke </th>
                                    <th> Kf </th>
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
                                    <th> Vrmax </th>
                                    <th> Vrmin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excIEEEAC1As.map(
                                        excIEEEAC1A => 
                                        <tr key = {excIEEEAC1A.excIEEEAC1AId}>
                                             <td> { excIEEEAC1A.ka } </td>
                                             <td> { excIEEEAC1A.kc } </td>
                                             <td> { excIEEEAC1A.kd } </td>
                                             <td> { excIEEEAC1A.ke } </td>
                                             <td> { excIEEEAC1A.kf } </td>
                                             <td> { excIEEEAC1A.seve1 } </td>
                                             <td> { excIEEEAC1A.seve2 } </td>
                                             <td> { excIEEEAC1A.ta } </td>
                                             <td> { excIEEEAC1A.tb } </td>
                                             <td> { excIEEEAC1A.tc } </td>
                                             <td> { excIEEEAC1A.te } </td>
                                             <td> { excIEEEAC1A.tf } </td>
                                             <td> { excIEEEAC1A.vamax } </td>
                                             <td> { excIEEEAC1A.vamin } </td>
                                             <td> { excIEEEAC1A.ve1 } </td>
                                             <td> { excIEEEAC1A.ve2 } </td>
                                             <td> { excIEEEAC1A.vrmax } </td>
                                             <td> { excIEEEAC1A.vrmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcIEEEAC1A(excIEEEAC1A.excIEEEAC1AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcIEEEAC1A(excIEEEAC1A.excIEEEAC1AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcIEEEAC1A(excIEEEAC1A.excIEEEAC1AId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcIEEEAC1AComponent
