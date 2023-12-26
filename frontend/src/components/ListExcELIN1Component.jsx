import React, { Component } from 'react'
import ExcELIN1Service from '../services/ExcELIN1Service'

class ListExcELIN1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excELIN1s: []
        }
        this.addExcELIN1 = this.addExcELIN1.bind(this);
        this.editExcELIN1 = this.editExcELIN1.bind(this);
        this.deleteExcELIN1 = this.deleteExcELIN1.bind(this);
    }

    deleteExcELIN1(id){
        ExcELIN1Service.deleteExcELIN1(id).then( res => {
            this.setState({excELIN1s: this.state.excELIN1s.filter(excELIN1 => excELIN1.excELIN1Id !== id)});
        });
    }
    viewExcELIN1(id){
        this.props.history.push(`/view-excELIN1/${id}`);
    }
    editExcELIN1(id){
        this.props.history.push(`/add-excELIN1/${id}`);
    }

    componentDidMount(){
        ExcELIN1Service.getExcELIN1s().then((res) => {
            this.setState({ excELIN1s: res.data});
        });
    }

    addExcELIN1(){
        this.props.history.push('/add-excELIN1/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcELIN1 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcELIN1}> Add ExcELIN1</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Dpnf </th>
                                    <th> Efmax </th>
                                    <th> Efmin </th>
                                    <th> Ks1 </th>
                                    <th> Ks2 </th>
                                    <th> Smax </th>
                                    <th> Tfi </th>
                                    <th> Tnu </th>
                                    <th> Ts1 </th>
                                    <th> Ts2 </th>
                                    <th> Tsw </th>
                                    <th> Vpi </th>
                                    <th> Vpnf </th>
                                    <th> Vpu </th>
                                    <th> Xe </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excELIN1s.map(
                                        excELIN1 => 
                                        <tr key = {excELIN1.excELIN1Id}>
                                             <td> { excELIN1.dpnf } </td>
                                             <td> { excELIN1.efmax } </td>
                                             <td> { excELIN1.efmin } </td>
                                             <td> { excELIN1.ks1 } </td>
                                             <td> { excELIN1.ks2 } </td>
                                             <td> { excELIN1.smax } </td>
                                             <td> { excELIN1.tfi } </td>
                                             <td> { excELIN1.tnu } </td>
                                             <td> { excELIN1.ts1 } </td>
                                             <td> { excELIN1.ts2 } </td>
                                             <td> { excELIN1.tsw } </td>
                                             <td> { excELIN1.vpi } </td>
                                             <td> { excELIN1.vpnf } </td>
                                             <td> { excELIN1.vpu } </td>
                                             <td> { excELIN1.xe } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcELIN1(excELIN1.excELIN1Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcELIN1(excELIN1.excELIN1Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcELIN1(excELIN1.excELIN1Id)} className="btn btn-info btn-sm">View </button>
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

export default ListExcELIN1Component
