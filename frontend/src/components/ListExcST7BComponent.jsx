import React, { Component } from 'react'
import ExcST7BService from '../services/ExcST7BService'

class ListExcST7BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excST7Bs: []
        }
        this.addExcST7B = this.addExcST7B.bind(this);
        this.editExcST7B = this.editExcST7B.bind(this);
        this.deleteExcST7B = this.deleteExcST7B.bind(this);
    }

    deleteExcST7B(id){
        ExcST7BService.deleteExcST7B(id).then( res => {
            this.setState({excST7Bs: this.state.excST7Bs.filter(excST7B => excST7B.excST7BId !== id)});
        });
    }
    viewExcST7B(id){
        this.props.history.push(`/view-excST7B/${id}`);
    }
    editExcST7B(id){
        this.props.history.push(`/add-excST7B/${id}`);
    }

    componentDidMount(){
        ExcST7BService.getExcST7Bs().then((res) => {
            this.setState({ excST7Bs: res.data});
        });
    }

    addExcST7B(){
        this.props.history.push('/add-excST7B/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcST7B List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcST7B}> Add ExcST7B</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Kh </th>
                                    <th> Kia </th>
                                    <th> Kl </th>
                                    <th> Kpa </th>
                                    <th> Oelin </th>
                                    <th> Tb </th>
                                    <th> Tc </th>
                                    <th> Tf </th>
                                    <th> Tg </th>
                                    <th> Tia </th>
                                    <th> Ts </th>
                                    <th> Uelin </th>
                                    <th> Vmax </th>
                                    <th> Vmin </th>
                                    <th> Vrmax </th>
                                    <th> Vrmin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excST7Bs.map(
                                        excST7B => 
                                        <tr key = {excST7B.excST7BId}>
                                             <td> { excST7B.kh } </td>
                                             <td> { excST7B.kia } </td>
                                             <td> { excST7B.kl } </td>
                                             <td> { excST7B.kpa } </td>
                                             <td> { excST7B.oelin } </td>
                                             <td> { excST7B.tb } </td>
                                             <td> { excST7B.tc } </td>
                                             <td> { excST7B.tf } </td>
                                             <td> { excST7B.tg } </td>
                                             <td> { excST7B.tia } </td>
                                             <td> { excST7B.ts } </td>
                                             <td> { excST7B.uelin } </td>
                                             <td> { excST7B.vmax } </td>
                                             <td> { excST7B.vmin } </td>
                                             <td> { excST7B.vrmax } </td>
                                             <td> { excST7B.vrmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcST7B(excST7B.excST7BId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcST7B(excST7B.excST7BId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcST7B(excST7B.excST7BId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcST7BComponent
