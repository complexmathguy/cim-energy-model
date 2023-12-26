import React, { Component } from 'react'
import ExcST6BService from '../services/ExcST6BService'

class ListExcST6BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excST6Bs: []
        }
        this.addExcST6B = this.addExcST6B.bind(this);
        this.editExcST6B = this.editExcST6B.bind(this);
        this.deleteExcST6B = this.deleteExcST6B.bind(this);
    }

    deleteExcST6B(id){
        ExcST6BService.deleteExcST6B(id).then( res => {
            this.setState({excST6Bs: this.state.excST6Bs.filter(excST6B => excST6B.excST6BId !== id)});
        });
    }
    viewExcST6B(id){
        this.props.history.push(`/view-excST6B/${id}`);
    }
    editExcST6B(id){
        this.props.history.push(`/add-excST6B/${id}`);
    }

    componentDidMount(){
        ExcST6BService.getExcST6Bs().then((res) => {
            this.setState({ excST6Bs: res.data});
        });
    }

    addExcST6B(){
        this.props.history.push('/add-excST6B/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcST6B List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcST6B}> Add ExcST6B</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Ilr </th>
                                    <th> K1 </th>
                                    <th> Kcl </th>
                                    <th> Kff </th>
                                    <th> Kg </th>
                                    <th> Kia </th>
                                    <th> Klr </th>
                                    <th> Km </th>
                                    <th> Kpa </th>
                                    <th> Kvd </th>
                                    <th> Oelin </th>
                                    <th> Tg </th>
                                    <th> Ts </th>
                                    <th> Tvd </th>
                                    <th> Vamax </th>
                                    <th> Vamin </th>
                                    <th> Vilim </th>
                                    <th> Vimax </th>
                                    <th> Vimin </th>
                                    <th> Vmult </th>
                                    <th> Vrmax </th>
                                    <th> Vrmin </th>
                                    <th> Xc </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excST6Bs.map(
                                        excST6B => 
                                        <tr key = {excST6B.excST6BId}>
                                             <td> { excST6B.ilr } </td>
                                             <td> { excST6B.k1 } </td>
                                             <td> { excST6B.kcl } </td>
                                             <td> { excST6B.kff } </td>
                                             <td> { excST6B.kg } </td>
                                             <td> { excST6B.kia } </td>
                                             <td> { excST6B.klr } </td>
                                             <td> { excST6B.km } </td>
                                             <td> { excST6B.kpa } </td>
                                             <td> { excST6B.kvd } </td>
                                             <td> { excST6B.oelin } </td>
                                             <td> { excST6B.tg } </td>
                                             <td> { excST6B.ts } </td>
                                             <td> { excST6B.tvd } </td>
                                             <td> { excST6B.vamax } </td>
                                             <td> { excST6B.vamin } </td>
                                             <td> { excST6B.vilim } </td>
                                             <td> { excST6B.vimax } </td>
                                             <td> { excST6B.vimin } </td>
                                             <td> { excST6B.vmult } </td>
                                             <td> { excST6B.vrmax } </td>
                                             <td> { excST6B.vrmin } </td>
                                             <td> { excST6B.xc } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcST6B(excST6B.excST6BId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcST6B(excST6B.excST6BId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcST6B(excST6B.excST6BId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcST6BComponent
