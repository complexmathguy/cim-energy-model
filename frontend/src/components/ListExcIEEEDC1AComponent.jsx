import React, { Component } from 'react'
import ExcIEEEDC1AService from '../services/ExcIEEEDC1AService'

class ListExcIEEEDC1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excIEEEDC1As: []
        }
        this.addExcIEEEDC1A = this.addExcIEEEDC1A.bind(this);
        this.editExcIEEEDC1A = this.editExcIEEEDC1A.bind(this);
        this.deleteExcIEEEDC1A = this.deleteExcIEEEDC1A.bind(this);
    }

    deleteExcIEEEDC1A(id){
        ExcIEEEDC1AService.deleteExcIEEEDC1A(id).then( res => {
            this.setState({excIEEEDC1As: this.state.excIEEEDC1As.filter(excIEEEDC1A => excIEEEDC1A.excIEEEDC1AId !== id)});
        });
    }
    viewExcIEEEDC1A(id){
        this.props.history.push(`/view-excIEEEDC1A/${id}`);
    }
    editExcIEEEDC1A(id){
        this.props.history.push(`/add-excIEEEDC1A/${id}`);
    }

    componentDidMount(){
        ExcIEEEDC1AService.getExcIEEEDC1As().then((res) => {
            this.setState({ excIEEEDC1As: res.data});
        });
    }

    addExcIEEEDC1A(){
        this.props.history.push('/add-excIEEEDC1A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcIEEEDC1A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcIEEEDC1A}> Add ExcIEEEDC1A</button>
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
                                    this.state.excIEEEDC1As.map(
                                        excIEEEDC1A => 
                                        <tr key = {excIEEEDC1A.excIEEEDC1AId}>
                                             <td> { excIEEEDC1A.efd1 } </td>
                                             <td> { excIEEEDC1A.efd2 } </td>
                                             <td> { excIEEEDC1A.exclim } </td>
                                             <td> { excIEEEDC1A.ka } </td>
                                             <td> { excIEEEDC1A.ke } </td>
                                             <td> { excIEEEDC1A.kf } </td>
                                             <td> { excIEEEDC1A.seefd1 } </td>
                                             <td> { excIEEEDC1A.seefd2 } </td>
                                             <td> { excIEEEDC1A.ta } </td>
                                             <td> { excIEEEDC1A.tb } </td>
                                             <td> { excIEEEDC1A.tc } </td>
                                             <td> { excIEEEDC1A.te } </td>
                                             <td> { excIEEEDC1A.tf } </td>
                                             <td> { excIEEEDC1A.uelin } </td>
                                             <td> { excIEEEDC1A.vrmax } </td>
                                             <td> { excIEEEDC1A.vrmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcIEEEDC1A(excIEEEDC1A.excIEEEDC1AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcIEEEDC1A(excIEEEDC1A.excIEEEDC1AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcIEEEDC1A(excIEEEDC1A.excIEEEDC1AId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcIEEEDC1AComponent
