import React, { Component } from 'react'
import ExcAC5AService from '../services/ExcAC5AService'

class ListExcAC5AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excAC5As: []
        }
        this.addExcAC5A = this.addExcAC5A.bind(this);
        this.editExcAC5A = this.editExcAC5A.bind(this);
        this.deleteExcAC5A = this.deleteExcAC5A.bind(this);
    }

    deleteExcAC5A(id){
        ExcAC5AService.deleteExcAC5A(id).then( res => {
            this.setState({excAC5As: this.state.excAC5As.filter(excAC5A => excAC5A.excAC5AId !== id)});
        });
    }
    viewExcAC5A(id){
        this.props.history.push(`/view-excAC5A/${id}`);
    }
    editExcAC5A(id){
        this.props.history.push(`/add-excAC5A/${id}`);
    }

    componentDidMount(){
        ExcAC5AService.getExcAC5As().then((res) => {
            this.setState({ excAC5As: res.data});
        });
    }

    addExcAC5A(){
        this.props.history.push('/add-excAC5A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcAC5A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcAC5A}> Add ExcAC5A</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> A </th>
                                    <th> Efd1 </th>
                                    <th> Efd2 </th>
                                    <th> Ka </th>
                                    <th> Ke </th>
                                    <th> Kf </th>
                                    <th> Ks </th>
                                    <th> Seefd1 </th>
                                    <th> Seefd2 </th>
                                    <th> Ta </th>
                                    <th> Tb </th>
                                    <th> Tc </th>
                                    <th> Te </th>
                                    <th> Tf1 </th>
                                    <th> Tf2 </th>
                                    <th> Tf3 </th>
                                    <th> Vrmax </th>
                                    <th> Vrmin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excAC5As.map(
                                        excAC5A => 
                                        <tr key = {excAC5A.excAC5AId}>
                                             <td> { excAC5A.a } </td>
                                             <td> { excAC5A.efd1 } </td>
                                             <td> { excAC5A.efd2 } </td>
                                             <td> { excAC5A.ka } </td>
                                             <td> { excAC5A.ke } </td>
                                             <td> { excAC5A.kf } </td>
                                             <td> { excAC5A.ks } </td>
                                             <td> { excAC5A.seefd1 } </td>
                                             <td> { excAC5A.seefd2 } </td>
                                             <td> { excAC5A.ta } </td>
                                             <td> { excAC5A.tb } </td>
                                             <td> { excAC5A.tc } </td>
                                             <td> { excAC5A.te } </td>
                                             <td> { excAC5A.tf1 } </td>
                                             <td> { excAC5A.tf2 } </td>
                                             <td> { excAC5A.tf3 } </td>
                                             <td> { excAC5A.vrmax } </td>
                                             <td> { excAC5A.vrmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcAC5A(excAC5A.excAC5AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcAC5A(excAC5A.excAC5AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcAC5A(excAC5A.excAC5AId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcAC5AComponent
