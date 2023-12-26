import React, { Component } from 'react'
import ExcIEEEAC6AService from '../services/ExcIEEEAC6AService'

class ListExcIEEEAC6AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excIEEEAC6As: []
        }
        this.addExcIEEEAC6A = this.addExcIEEEAC6A.bind(this);
        this.editExcIEEEAC6A = this.editExcIEEEAC6A.bind(this);
        this.deleteExcIEEEAC6A = this.deleteExcIEEEAC6A.bind(this);
    }

    deleteExcIEEEAC6A(id){
        ExcIEEEAC6AService.deleteExcIEEEAC6A(id).then( res => {
            this.setState({excIEEEAC6As: this.state.excIEEEAC6As.filter(excIEEEAC6A => excIEEEAC6A.excIEEEAC6AId !== id)});
        });
    }
    viewExcIEEEAC6A(id){
        this.props.history.push(`/view-excIEEEAC6A/${id}`);
    }
    editExcIEEEAC6A(id){
        this.props.history.push(`/add-excIEEEAC6A/${id}`);
    }

    componentDidMount(){
        ExcIEEEAC6AService.getExcIEEEAC6As().then((res) => {
            this.setState({ excIEEEAC6As: res.data});
        });
    }

    addExcIEEEAC6A(){
        this.props.history.push('/add-excIEEEAC6A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcIEEEAC6A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcIEEEAC6A}> Add ExcIEEEAC6A</button>
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
                                    this.state.excIEEEAC6As.map(
                                        excIEEEAC6A => 
                                        <tr key = {excIEEEAC6A.excIEEEAC6AId}>
                                             <td> { excIEEEAC6A.ka } </td>
                                             <td> { excIEEEAC6A.kc } </td>
                                             <td> { excIEEEAC6A.kd } </td>
                                             <td> { excIEEEAC6A.ke } </td>
                                             <td> { excIEEEAC6A.kh } </td>
                                             <td> { excIEEEAC6A.seve1 } </td>
                                             <td> { excIEEEAC6A.seve2 } </td>
                                             <td> { excIEEEAC6A.ta } </td>
                                             <td> { excIEEEAC6A.tb } </td>
                                             <td> { excIEEEAC6A.tc } </td>
                                             <td> { excIEEEAC6A.te } </td>
                                             <td> { excIEEEAC6A.th } </td>
                                             <td> { excIEEEAC6A.tj } </td>
                                             <td> { excIEEEAC6A.tk } </td>
                                             <td> { excIEEEAC6A.vamax } </td>
                                             <td> { excIEEEAC6A.vamin } </td>
                                             <td> { excIEEEAC6A.ve1 } </td>
                                             <td> { excIEEEAC6A.ve2 } </td>
                                             <td> { excIEEEAC6A.vfelim } </td>
                                             <td> { excIEEEAC6A.vhmax } </td>
                                             <td> { excIEEEAC6A.vrmax } </td>
                                             <td> { excIEEEAC6A.vrmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcIEEEAC6A(excIEEEAC6A.excIEEEAC6AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcIEEEAC6A(excIEEEAC6A.excIEEEAC6AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcIEEEAC6A(excIEEEAC6A.excIEEEAC6AId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcIEEEAC6AComponent
