import React, { Component } from 'react'
import ExcDC3AService from '../services/ExcDC3AService'

class ListExcDC3AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excDC3As: []
        }
        this.addExcDC3A = this.addExcDC3A.bind(this);
        this.editExcDC3A = this.editExcDC3A.bind(this);
        this.deleteExcDC3A = this.deleteExcDC3A.bind(this);
    }

    deleteExcDC3A(id){
        ExcDC3AService.deleteExcDC3A(id).then( res => {
            this.setState({excDC3As: this.state.excDC3As.filter(excDC3A => excDC3A.excDC3AId !== id)});
        });
    }
    viewExcDC3A(id){
        this.props.history.push(`/view-excDC3A/${id}`);
    }
    editExcDC3A(id){
        this.props.history.push(`/add-excDC3A/${id}`);
    }

    componentDidMount(){
        ExcDC3AService.getExcDC3As().then((res) => {
            this.setState({ excDC3As: res.data});
        });
    }

    addExcDC3A(){
        this.props.history.push('/add-excDC3A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcDC3A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcDC3A}> Add ExcDC3A</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Edfmax </th>
                                    <th> Efd1 </th>
                                    <th> Efd2 </th>
                                    <th> Efdlim </th>
                                    <th> Efdmin </th>
                                    <th> Exclim </th>
                                    <th> Ke </th>
                                    <th> Kr </th>
                                    <th> Ks </th>
                                    <th> Kv </th>
                                    <th> Seefd1 </th>
                                    <th> Seefd2 </th>
                                    <th> Te </th>
                                    <th> Trh </th>
                                    <th> Vrmax </th>
                                    <th> Vrmin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excDC3As.map(
                                        excDC3A => 
                                        <tr key = {excDC3A.excDC3AId}>
                                             <td> { excDC3A.edfmax } </td>
                                             <td> { excDC3A.efd1 } </td>
                                             <td> { excDC3A.efd2 } </td>
                                             <td> { excDC3A.efdlim } </td>
                                             <td> { excDC3A.efdmin } </td>
                                             <td> { excDC3A.exclim } </td>
                                             <td> { excDC3A.ke } </td>
                                             <td> { excDC3A.kr } </td>
                                             <td> { excDC3A.ks } </td>
                                             <td> { excDC3A.kv } </td>
                                             <td> { excDC3A.seefd1 } </td>
                                             <td> { excDC3A.seefd2 } </td>
                                             <td> { excDC3A.te } </td>
                                             <td> { excDC3A.trh } </td>
                                             <td> { excDC3A.vrmax } </td>
                                             <td> { excDC3A.vrmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcDC3A(excDC3A.excDC3AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcDC3A(excDC3A.excDC3AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcDC3A(excDC3A.excDC3AId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcDC3AComponent
