import React, { Component } from 'react'
import ExcAC1AService from '../services/ExcAC1AService'

class ListExcAC1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excAC1As: []
        }
        this.addExcAC1A = this.addExcAC1A.bind(this);
        this.editExcAC1A = this.editExcAC1A.bind(this);
        this.deleteExcAC1A = this.deleteExcAC1A.bind(this);
    }

    deleteExcAC1A(id){
        ExcAC1AService.deleteExcAC1A(id).then( res => {
            this.setState({excAC1As: this.state.excAC1As.filter(excAC1A => excAC1A.excAC1AId !== id)});
        });
    }
    viewExcAC1A(id){
        this.props.history.push(`/view-excAC1A/${id}`);
    }
    editExcAC1A(id){
        this.props.history.push(`/add-excAC1A/${id}`);
    }

    componentDidMount(){
        ExcAC1AService.getExcAC1As().then((res) => {
            this.setState({ excAC1As: res.data});
        });
    }

    addExcAC1A(){
        this.props.history.push('/add-excAC1A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcAC1A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcAC1A}> Add ExcAC1A</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Hvlvgates </th>
                                    <th> Ka </th>
                                    <th> Kc </th>
                                    <th> Kd </th>
                                    <th> Ke </th>
                                    <th> Kf </th>
                                    <th> Kf1 </th>
                                    <th> Kf2 </th>
                                    <th> Ks </th>
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
                                    this.state.excAC1As.map(
                                        excAC1A => 
                                        <tr key = {excAC1A.excAC1AId}>
                                             <td> { excAC1A.hvlvgates } </td>
                                             <td> { excAC1A.ka } </td>
                                             <td> { excAC1A.kc } </td>
                                             <td> { excAC1A.kd } </td>
                                             <td> { excAC1A.ke } </td>
                                             <td> { excAC1A.kf } </td>
                                             <td> { excAC1A.kf1 } </td>
                                             <td> { excAC1A.kf2 } </td>
                                             <td> { excAC1A.ks } </td>
                                             <td> { excAC1A.seve1 } </td>
                                             <td> { excAC1A.seve2 } </td>
                                             <td> { excAC1A.ta } </td>
                                             <td> { excAC1A.tb } </td>
                                             <td> { excAC1A.tc } </td>
                                             <td> { excAC1A.te } </td>
                                             <td> { excAC1A.tf } </td>
                                             <td> { excAC1A.vamax } </td>
                                             <td> { excAC1A.vamin } </td>
                                             <td> { excAC1A.ve1 } </td>
                                             <td> { excAC1A.ve2 } </td>
                                             <td> { excAC1A.vrmax } </td>
                                             <td> { excAC1A.vrmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcAC1A(excAC1A.excAC1AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcAC1A(excAC1A.excAC1AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcAC1A(excAC1A.excAC1AId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcAC1AComponent
