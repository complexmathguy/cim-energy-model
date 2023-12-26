import React, { Component } from 'react'
import ExcDC2AService from '../services/ExcDC2AService'

class ListExcDC2AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excDC2As: []
        }
        this.addExcDC2A = this.addExcDC2A.bind(this);
        this.editExcDC2A = this.editExcDC2A.bind(this);
        this.deleteExcDC2A = this.deleteExcDC2A.bind(this);
    }

    deleteExcDC2A(id){
        ExcDC2AService.deleteExcDC2A(id).then( res => {
            this.setState({excDC2As: this.state.excDC2As.filter(excDC2A => excDC2A.excDC2AId !== id)});
        });
    }
    viewExcDC2A(id){
        this.props.history.push(`/view-excDC2A/${id}`);
    }
    editExcDC2A(id){
        this.props.history.push(`/add-excDC2A/${id}`);
    }

    componentDidMount(){
        ExcDC2AService.getExcDC2As().then((res) => {
            this.setState({ excDC2As: res.data});
        });
    }

    addExcDC2A(){
        this.props.history.push('/add-excDC2A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcDC2A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcDC2A}> Add ExcDC2A</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Efd1 </th>
                                    <th> Efd2 </th>
                                    <th> Exclim </th>
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
                                    <th> Tf </th>
                                    <th> Tf1 </th>
                                    <th> Vrmax </th>
                                    <th> Vrmin </th>
                                    <th> Vtlim </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excDC2As.map(
                                        excDC2A => 
                                        <tr key = {excDC2A.excDC2AId}>
                                             <td> { excDC2A.efd1 } </td>
                                             <td> { excDC2A.efd2 } </td>
                                             <td> { excDC2A.exclim } </td>
                                             <td> { excDC2A.ka } </td>
                                             <td> { excDC2A.ke } </td>
                                             <td> { excDC2A.kf } </td>
                                             <td> { excDC2A.ks } </td>
                                             <td> { excDC2A.seefd1 } </td>
                                             <td> { excDC2A.seefd2 } </td>
                                             <td> { excDC2A.ta } </td>
                                             <td> { excDC2A.tb } </td>
                                             <td> { excDC2A.tc } </td>
                                             <td> { excDC2A.te } </td>
                                             <td> { excDC2A.tf } </td>
                                             <td> { excDC2A.tf1 } </td>
                                             <td> { excDC2A.vrmax } </td>
                                             <td> { excDC2A.vrmin } </td>
                                             <td> { excDC2A.vtlim } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcDC2A(excDC2A.excDC2AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcDC2A(excDC2A.excDC2AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcDC2A(excDC2A.excDC2AId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcDC2AComponent
