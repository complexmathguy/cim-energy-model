import React, { Component } from 'react'
import ExcDC1AService from '../services/ExcDC1AService'

class ListExcDC1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excDC1As: []
        }
        this.addExcDC1A = this.addExcDC1A.bind(this);
        this.editExcDC1A = this.editExcDC1A.bind(this);
        this.deleteExcDC1A = this.deleteExcDC1A.bind(this);
    }

    deleteExcDC1A(id){
        ExcDC1AService.deleteExcDC1A(id).then( res => {
            this.setState({excDC1As: this.state.excDC1As.filter(excDC1A => excDC1A.excDC1AId !== id)});
        });
    }
    viewExcDC1A(id){
        this.props.history.push(`/view-excDC1A/${id}`);
    }
    editExcDC1A(id){
        this.props.history.push(`/add-excDC1A/${id}`);
    }

    componentDidMount(){
        ExcDC1AService.getExcDC1As().then((res) => {
            this.setState({ excDC1As: res.data});
        });
    }

    addExcDC1A(){
        this.props.history.push('/add-excDC1A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcDC1A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcDC1A}> Add ExcDC1A</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Edfmax </th>
                                    <th> Efd1 </th>
                                    <th> Efd2 </th>
                                    <th> Efdmin </th>
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
                                    <th> Vrmax </th>
                                    <th> Vrmin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excDC1As.map(
                                        excDC1A => 
                                        <tr key = {excDC1A.excDC1AId}>
                                             <td> { excDC1A.edfmax } </td>
                                             <td> { excDC1A.efd1 } </td>
                                             <td> { excDC1A.efd2 } </td>
                                             <td> { excDC1A.efdmin } </td>
                                             <td> { excDC1A.exclim } </td>
                                             <td> { excDC1A.ka } </td>
                                             <td> { excDC1A.ke } </td>
                                             <td> { excDC1A.kf } </td>
                                             <td> { excDC1A.ks } </td>
                                             <td> { excDC1A.seefd1 } </td>
                                             <td> { excDC1A.seefd2 } </td>
                                             <td> { excDC1A.ta } </td>
                                             <td> { excDC1A.tb } </td>
                                             <td> { excDC1A.tc } </td>
                                             <td> { excDC1A.te } </td>
                                             <td> { excDC1A.tf } </td>
                                             <td> { excDC1A.vrmax } </td>
                                             <td> { excDC1A.vrmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcDC1A(excDC1A.excDC1AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcDC1A(excDC1A.excDC1AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcDC1A(excDC1A.excDC1AId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcDC1AComponent
