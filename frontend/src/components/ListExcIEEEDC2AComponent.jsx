import React, { Component } from 'react'
import ExcIEEEDC2AService from '../services/ExcIEEEDC2AService'

class ListExcIEEEDC2AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excIEEEDC2As: []
        }
        this.addExcIEEEDC2A = this.addExcIEEEDC2A.bind(this);
        this.editExcIEEEDC2A = this.editExcIEEEDC2A.bind(this);
        this.deleteExcIEEEDC2A = this.deleteExcIEEEDC2A.bind(this);
    }

    deleteExcIEEEDC2A(id){
        ExcIEEEDC2AService.deleteExcIEEEDC2A(id).then( res => {
            this.setState({excIEEEDC2As: this.state.excIEEEDC2As.filter(excIEEEDC2A => excIEEEDC2A.excIEEEDC2AId !== id)});
        });
    }
    viewExcIEEEDC2A(id){
        this.props.history.push(`/view-excIEEEDC2A/${id}`);
    }
    editExcIEEEDC2A(id){
        this.props.history.push(`/add-excIEEEDC2A/${id}`);
    }

    componentDidMount(){
        ExcIEEEDC2AService.getExcIEEEDC2As().then((res) => {
            this.setState({ excIEEEDC2As: res.data});
        });
    }

    addExcIEEEDC2A(){
        this.props.history.push('/add-excIEEEDC2A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcIEEEDC2A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcIEEEDC2A}> Add ExcIEEEDC2A</button>
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
                                    <th> Seefd1 </th>
                                    <th> Seefd2 </th>
                                    <th> Ta </th>
                                    <th> Tb </th>
                                    <th> Tc </th>
                                    <th> Te </th>
                                    <th> Tf </th>
                                    <th> Uelin </th>
                                    <th> Vrmax </th>
                                    <th> Vrmin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excIEEEDC2As.map(
                                        excIEEEDC2A => 
                                        <tr key = {excIEEEDC2A.excIEEEDC2AId}>
                                             <td> { excIEEEDC2A.efd1 } </td>
                                             <td> { excIEEEDC2A.efd2 } </td>
                                             <td> { excIEEEDC2A.exclim } </td>
                                             <td> { excIEEEDC2A.ka } </td>
                                             <td> { excIEEEDC2A.ke } </td>
                                             <td> { excIEEEDC2A.kf } </td>
                                             <td> { excIEEEDC2A.seefd1 } </td>
                                             <td> { excIEEEDC2A.seefd2 } </td>
                                             <td> { excIEEEDC2A.ta } </td>
                                             <td> { excIEEEDC2A.tb } </td>
                                             <td> { excIEEEDC2A.tc } </td>
                                             <td> { excIEEEDC2A.te } </td>
                                             <td> { excIEEEDC2A.tf } </td>
                                             <td> { excIEEEDC2A.uelin } </td>
                                             <td> { excIEEEDC2A.vrmax } </td>
                                             <td> { excIEEEDC2A.vrmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcIEEEDC2A(excIEEEDC2A.excIEEEDC2AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcIEEEDC2A(excIEEEDC2A.excIEEEDC2AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcIEEEDC2A(excIEEEDC2A.excIEEEDC2AId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcIEEEDC2AComponent
