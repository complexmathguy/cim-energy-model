import React, { Component } from 'react'
import ExcIEEEDC4BService from '../services/ExcIEEEDC4BService'

class ListExcIEEEDC4BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excIEEEDC4Bs: []
        }
        this.addExcIEEEDC4B = this.addExcIEEEDC4B.bind(this);
        this.editExcIEEEDC4B = this.editExcIEEEDC4B.bind(this);
        this.deleteExcIEEEDC4B = this.deleteExcIEEEDC4B.bind(this);
    }

    deleteExcIEEEDC4B(id){
        ExcIEEEDC4BService.deleteExcIEEEDC4B(id).then( res => {
            this.setState({excIEEEDC4Bs: this.state.excIEEEDC4Bs.filter(excIEEEDC4B => excIEEEDC4B.excIEEEDC4BId !== id)});
        });
    }
    viewExcIEEEDC4B(id){
        this.props.history.push(`/view-excIEEEDC4B/${id}`);
    }
    editExcIEEEDC4B(id){
        this.props.history.push(`/add-excIEEEDC4B/${id}`);
    }

    componentDidMount(){
        ExcIEEEDC4BService.getExcIEEEDC4Bs().then((res) => {
            this.setState({ excIEEEDC4Bs: res.data});
        });
    }

    addExcIEEEDC4B(){
        this.props.history.push('/add-excIEEEDC4B/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcIEEEDC4B List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcIEEEDC4B}> Add ExcIEEEDC4B</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Efd1 </th>
                                    <th> Efd2 </th>
                                    <th> Ka </th>
                                    <th> Kd </th>
                                    <th> Ke </th>
                                    <th> Kf </th>
                                    <th> Ki </th>
                                    <th> Kp </th>
                                    <th> Oelin </th>
                                    <th> Seefd1 </th>
                                    <th> Seefd2 </th>
                                    <th> Ta </th>
                                    <th> Td </th>
                                    <th> Te </th>
                                    <th> Tf </th>
                                    <th> Uelin </th>
                                    <th> Vemin </th>
                                    <th> Vrmax </th>
                                    <th> Vrmin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excIEEEDC4Bs.map(
                                        excIEEEDC4B => 
                                        <tr key = {excIEEEDC4B.excIEEEDC4BId}>
                                             <td> { excIEEEDC4B.efd1 } </td>
                                             <td> { excIEEEDC4B.efd2 } </td>
                                             <td> { excIEEEDC4B.ka } </td>
                                             <td> { excIEEEDC4B.kd } </td>
                                             <td> { excIEEEDC4B.ke } </td>
                                             <td> { excIEEEDC4B.kf } </td>
                                             <td> { excIEEEDC4B.ki } </td>
                                             <td> { excIEEEDC4B.kp } </td>
                                             <td> { excIEEEDC4B.oelin } </td>
                                             <td> { excIEEEDC4B.seefd1 } </td>
                                             <td> { excIEEEDC4B.seefd2 } </td>
                                             <td> { excIEEEDC4B.ta } </td>
                                             <td> { excIEEEDC4B.td } </td>
                                             <td> { excIEEEDC4B.te } </td>
                                             <td> { excIEEEDC4B.tf } </td>
                                             <td> { excIEEEDC4B.uelin } </td>
                                             <td> { excIEEEDC4B.vemin } </td>
                                             <td> { excIEEEDC4B.vrmax } </td>
                                             <td> { excIEEEDC4B.vrmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcIEEEDC4B(excIEEEDC4B.excIEEEDC4BId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcIEEEDC4B(excIEEEDC4B.excIEEEDC4BId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcIEEEDC4B(excIEEEDC4B.excIEEEDC4BId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcIEEEDC4BComponent
