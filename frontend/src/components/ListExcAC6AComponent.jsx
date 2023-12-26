import React, { Component } from 'react'
import ExcAC6AService from '../services/ExcAC6AService'

class ListExcAC6AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excAC6As: []
        }
        this.addExcAC6A = this.addExcAC6A.bind(this);
        this.editExcAC6A = this.editExcAC6A.bind(this);
        this.deleteExcAC6A = this.deleteExcAC6A.bind(this);
    }

    deleteExcAC6A(id){
        ExcAC6AService.deleteExcAC6A(id).then( res => {
            this.setState({excAC6As: this.state.excAC6As.filter(excAC6A => excAC6A.excAC6AId !== id)});
        });
    }
    viewExcAC6A(id){
        this.props.history.push(`/view-excAC6A/${id}`);
    }
    editExcAC6A(id){
        this.props.history.push(`/add-excAC6A/${id}`);
    }

    componentDidMount(){
        ExcAC6AService.getExcAC6As().then((res) => {
            this.setState({ excAC6As: res.data});
        });
    }

    addExcAC6A(){
        this.props.history.push('/add-excAC6A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcAC6A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcAC6A}> Add ExcAC6A</button>
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
                                    <th> Kh </th>
                                    <th> Ks </th>
                                    <th> Seve1 </th>
                                    <th> Seve2 </th>
                                    <th> Ta </th>
                                    <th> Tb </th>
                                    <th> Tc </th>
                                    <th> Te </th>
                                    <th> Th </th>
                                    <th> Tj </th>
                                    <th> Tk </th>
                                    <th> Vamax </th>
                                    <th> Vamin </th>
                                    <th> Ve1 </th>
                                    <th> Ve2 </th>
                                    <th> Vfelim </th>
                                    <th> Vhmax </th>
                                    <th> Vrmax </th>
                                    <th> Vrmin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excAC6As.map(
                                        excAC6A => 
                                        <tr key = {excAC6A.excAC6AId}>
                                             <td> { excAC6A.ka } </td>
                                             <td> { excAC6A.kc } </td>
                                             <td> { excAC6A.kd } </td>
                                             <td> { excAC6A.ke } </td>
                                             <td> { excAC6A.kh } </td>
                                             <td> { excAC6A.ks } </td>
                                             <td> { excAC6A.seve1 } </td>
                                             <td> { excAC6A.seve2 } </td>
                                             <td> { excAC6A.ta } </td>
                                             <td> { excAC6A.tb } </td>
                                             <td> { excAC6A.tc } </td>
                                             <td> { excAC6A.te } </td>
                                             <td> { excAC6A.th } </td>
                                             <td> { excAC6A.tj } </td>
                                             <td> { excAC6A.tk } </td>
                                             <td> { excAC6A.vamax } </td>
                                             <td> { excAC6A.vamin } </td>
                                             <td> { excAC6A.ve1 } </td>
                                             <td> { excAC6A.ve2 } </td>
                                             <td> { excAC6A.vfelim } </td>
                                             <td> { excAC6A.vhmax } </td>
                                             <td> { excAC6A.vrmax } </td>
                                             <td> { excAC6A.vrmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcAC6A(excAC6A.excAC6AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcAC6A(excAC6A.excAC6AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcAC6A(excAC6A.excAC6AId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcAC6AComponent
