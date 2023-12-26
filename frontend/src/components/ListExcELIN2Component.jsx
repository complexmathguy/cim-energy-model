import React, { Component } from 'react'
import ExcELIN2Service from '../services/ExcELIN2Service'

class ListExcELIN2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excELIN2s: []
        }
        this.addExcELIN2 = this.addExcELIN2.bind(this);
        this.editExcELIN2 = this.editExcELIN2.bind(this);
        this.deleteExcELIN2 = this.deleteExcELIN2.bind(this);
    }

    deleteExcELIN2(id){
        ExcELIN2Service.deleteExcELIN2(id).then( res => {
            this.setState({excELIN2s: this.state.excELIN2s.filter(excELIN2 => excELIN2.excELIN2Id !== id)});
        });
    }
    viewExcELIN2(id){
        this.props.history.push(`/view-excELIN2/${id}`);
    }
    editExcELIN2(id){
        this.props.history.push(`/add-excELIN2/${id}`);
    }

    componentDidMount(){
        ExcELIN2Service.getExcELIN2s().then((res) => {
            this.setState({ excELIN2s: res.data});
        });
    }

    addExcELIN2(){
        this.props.history.push('/add-excELIN2/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcELIN2 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcELIN2}> Add ExcELIN2</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Efdbas </th>
                                    <th> Iefmax </th>
                                    <th> Iefmax2 </th>
                                    <th> Iefmin </th>
                                    <th> K1 </th>
                                    <th> K1ec </th>
                                    <th> K2 </th>
                                    <th> K3 </th>
                                    <th> K4 </th>
                                    <th> Kd1 </th>
                                    <th> Ke2 </th>
                                    <th> Ketb </th>
                                    <th> Pid1max </th>
                                    <th> Seve1 </th>
                                    <th> Seve2 </th>
                                    <th> Tb1 </th>
                                    <th> Te </th>
                                    <th> Te2 </th>
                                    <th> Ti1 </th>
                                    <th> Ti3 </th>
                                    <th> Ti4 </th>
                                    <th> Tr4 </th>
                                    <th> Upmax </th>
                                    <th> Upmin </th>
                                    <th> Ve1 </th>
                                    <th> Ve2 </th>
                                    <th> Xp </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excELIN2s.map(
                                        excELIN2 => 
                                        <tr key = {excELIN2.excELIN2Id}>
                                             <td> { excELIN2.efdbas } </td>
                                             <td> { excELIN2.iefmax } </td>
                                             <td> { excELIN2.iefmax2 } </td>
                                             <td> { excELIN2.iefmin } </td>
                                             <td> { excELIN2.k1 } </td>
                                             <td> { excELIN2.k1ec } </td>
                                             <td> { excELIN2.k2 } </td>
                                             <td> { excELIN2.k3 } </td>
                                             <td> { excELIN2.k4 } </td>
                                             <td> { excELIN2.kd1 } </td>
                                             <td> { excELIN2.ke2 } </td>
                                             <td> { excELIN2.ketb } </td>
                                             <td> { excELIN2.pid1max } </td>
                                             <td> { excELIN2.seve1 } </td>
                                             <td> { excELIN2.seve2 } </td>
                                             <td> { excELIN2.tb1 } </td>
                                             <td> { excELIN2.te } </td>
                                             <td> { excELIN2.te2 } </td>
                                             <td> { excELIN2.ti1 } </td>
                                             <td> { excELIN2.ti3 } </td>
                                             <td> { excELIN2.ti4 } </td>
                                             <td> { excELIN2.tr4 } </td>
                                             <td> { excELIN2.upmax } </td>
                                             <td> { excELIN2.upmin } </td>
                                             <td> { excELIN2.ve1 } </td>
                                             <td> { excELIN2.ve2 } </td>
                                             <td> { excELIN2.xp } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcELIN2(excELIN2.excELIN2Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcELIN2(excELIN2.excELIN2Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcELIN2(excELIN2.excELIN2Id)} className="btn btn-info btn-sm">View </button>
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

export default ListExcELIN2Component
