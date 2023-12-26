import React, { Component } from 'react'
import WindContQIECService from '../services/WindContQIECService'

class ListWindContQIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                windContQIECs: []
        }
        this.addWindContQIEC = this.addWindContQIEC.bind(this);
        this.editWindContQIEC = this.editWindContQIEC.bind(this);
        this.deleteWindContQIEC = this.deleteWindContQIEC.bind(this);
    }

    deleteWindContQIEC(id){
        WindContQIECService.deleteWindContQIEC(id).then( res => {
            this.setState({windContQIECs: this.state.windContQIECs.filter(windContQIEC => windContQIEC.windContQIECId !== id)});
        });
    }
    viewWindContQIEC(id){
        this.props.history.push(`/view-windContQIEC/${id}`);
    }
    editWindContQIEC(id){
        this.props.history.push(`/add-windContQIEC/${id}`);
    }

    componentDidMount(){
        WindContQIECService.getWindContQIECs().then((res) => {
            this.setState({ windContQIECs: res.data});
        });
    }

    addWindContQIEC(){
        this.props.history.push('/add-windContQIEC/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">WindContQIEC List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addWindContQIEC}> Add WindContQIEC</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Iqh1 </th>
                                    <th> Iqmax </th>
                                    <th> Iqmin </th>
                                    <th> Iqpost </th>
                                    <th> Kiq </th>
                                    <th> Kiu </th>
                                    <th> Kpq </th>
                                    <th> Kpu </th>
                                    <th> Kqv </th>
                                    <th> Qmax </th>
                                    <th> Qmin </th>
                                    <th> Rdroop </th>
                                    <th> Tiq </th>
                                    <th> Tpfilt </th>
                                    <th> Tpost </th>
                                    <th> Tqord </th>
                                    <th> Tufilt </th>
                                    <th> Udb1 </th>
                                    <th> Udb2 </th>
                                    <th> Umax </th>
                                    <th> Umin </th>
                                    <th> Uqdip </th>
                                    <th> Uref0 </th>
                                    <th> WindLVRTQcontrolModesType </th>
                                    <th> WindQcontrolModesType </th>
                                    <th> Xdroop </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.windContQIECs.map(
                                        windContQIEC => 
                                        <tr key = {windContQIEC.windContQIECId}>
                                             <td> { windContQIEC.iqh1 } </td>
                                             <td> { windContQIEC.iqmax } </td>
                                             <td> { windContQIEC.iqmin } </td>
                                             <td> { windContQIEC.iqpost } </td>
                                             <td> { windContQIEC.kiq } </td>
                                             <td> { windContQIEC.kiu } </td>
                                             <td> { windContQIEC.kpq } </td>
                                             <td> { windContQIEC.kpu } </td>
                                             <td> { windContQIEC.kqv } </td>
                                             <td> { windContQIEC.qmax } </td>
                                             <td> { windContQIEC.qmin } </td>
                                             <td> { windContQIEC.rdroop } </td>
                                             <td> { windContQIEC.tiq } </td>
                                             <td> { windContQIEC.tpfilt } </td>
                                             <td> { windContQIEC.tpost } </td>
                                             <td> { windContQIEC.tqord } </td>
                                             <td> { windContQIEC.tufilt } </td>
                                             <td> { windContQIEC.udb1 } </td>
                                             <td> { windContQIEC.udb2 } </td>
                                             <td> { windContQIEC.umax } </td>
                                             <td> { windContQIEC.umin } </td>
                                             <td> { windContQIEC.uqdip } </td>
                                             <td> { windContQIEC.uref0 } </td>
                                             <td> { windContQIEC.windLVRTQcontrolModesType } </td>
                                             <td> { windContQIEC.windQcontrolModesType } </td>
                                             <td> { windContQIEC.xdroop } </td>
                                             <td>
                                                 <button onClick={ () => this.editWindContQIEC(windContQIEC.windContQIECId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteWindContQIEC(windContQIEC.windContQIECId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewWindContQIEC(windContQIEC.windContQIECId)} className="btn btn-info btn-sm">View </button>
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

export default ListWindContQIECComponent
