import React, { Component } from 'react'
import ExcIEEEST6BService from '../services/ExcIEEEST6BService'

class ListExcIEEEST6BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excIEEEST6Bs: []
        }
        this.addExcIEEEST6B = this.addExcIEEEST6B.bind(this);
        this.editExcIEEEST6B = this.editExcIEEEST6B.bind(this);
        this.deleteExcIEEEST6B = this.deleteExcIEEEST6B.bind(this);
    }

    deleteExcIEEEST6B(id){
        ExcIEEEST6BService.deleteExcIEEEST6B(id).then( res => {
            this.setState({excIEEEST6Bs: this.state.excIEEEST6Bs.filter(excIEEEST6B => excIEEEST6B.excIEEEST6BId !== id)});
        });
    }
    viewExcIEEEST6B(id){
        this.props.history.push(`/view-excIEEEST6B/${id}`);
    }
    editExcIEEEST6B(id){
        this.props.history.push(`/add-excIEEEST6B/${id}`);
    }

    componentDidMount(){
        ExcIEEEST6BService.getExcIEEEST6Bs().then((res) => {
            this.setState({ excIEEEST6Bs: res.data});
        });
    }

    addExcIEEEST6B(){
        this.props.history.push('/add-excIEEEST6B/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcIEEEST6B List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcIEEEST6B}> Add ExcIEEEST6B</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Ilr </th>
                                    <th> Kci </th>
                                    <th> Kff </th>
                                    <th> Kg </th>
                                    <th> Kia </th>
                                    <th> Klr </th>
                                    <th> Km </th>
                                    <th> Kpa </th>
                                    <th> Oelin </th>
                                    <th> Tg </th>
                                    <th> Vamax </th>
                                    <th> Vamin </th>
                                    <th> Vrmax </th>
                                    <th> Vrmin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excIEEEST6Bs.map(
                                        excIEEEST6B => 
                                        <tr key = {excIEEEST6B.excIEEEST6BId}>
                                             <td> { excIEEEST6B.ilr } </td>
                                             <td> { excIEEEST6B.kci } </td>
                                             <td> { excIEEEST6B.kff } </td>
                                             <td> { excIEEEST6B.kg } </td>
                                             <td> { excIEEEST6B.kia } </td>
                                             <td> { excIEEEST6B.klr } </td>
                                             <td> { excIEEEST6B.km } </td>
                                             <td> { excIEEEST6B.kpa } </td>
                                             <td> { excIEEEST6B.oelin } </td>
                                             <td> { excIEEEST6B.tg } </td>
                                             <td> { excIEEEST6B.vamax } </td>
                                             <td> { excIEEEST6B.vamin } </td>
                                             <td> { excIEEEST6B.vrmax } </td>
                                             <td> { excIEEEST6B.vrmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcIEEEST6B(excIEEEST6B.excIEEEST6BId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcIEEEST6B(excIEEEST6B.excIEEEST6BId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcIEEEST6B(excIEEEST6B.excIEEEST6BId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcIEEEST6BComponent
