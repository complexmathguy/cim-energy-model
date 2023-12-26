import React, { Component } from 'react'
import WindContPitchAngleIECService from '../services/WindContPitchAngleIECService'

class ListWindContPitchAngleIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                windContPitchAngleIECs: []
        }
        this.addWindContPitchAngleIEC = this.addWindContPitchAngleIEC.bind(this);
        this.editWindContPitchAngleIEC = this.editWindContPitchAngleIEC.bind(this);
        this.deleteWindContPitchAngleIEC = this.deleteWindContPitchAngleIEC.bind(this);
    }

    deleteWindContPitchAngleIEC(id){
        WindContPitchAngleIECService.deleteWindContPitchAngleIEC(id).then( res => {
            this.setState({windContPitchAngleIECs: this.state.windContPitchAngleIECs.filter(windContPitchAngleIEC => windContPitchAngleIEC.windContPitchAngleIECId !== id)});
        });
    }
    viewWindContPitchAngleIEC(id){
        this.props.history.push(`/view-windContPitchAngleIEC/${id}`);
    }
    editWindContPitchAngleIEC(id){
        this.props.history.push(`/add-windContPitchAngleIEC/${id}`);
    }

    componentDidMount(){
        WindContPitchAngleIECService.getWindContPitchAngleIECs().then((res) => {
            this.setState({ windContPitchAngleIECs: res.data});
        });
    }

    addWindContPitchAngleIEC(){
        this.props.history.push('/add-windContPitchAngleIEC/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">WindContPitchAngleIEC List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addWindContPitchAngleIEC}> Add WindContPitchAngleIEC</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Dthetamax </th>
                                    <th> Dthetamin </th>
                                    <th> Kic </th>
                                    <th> Kiomega </th>
                                    <th> Kpc </th>
                                    <th> Kpomega </th>
                                    <th> Kpx </th>
                                    <th> Thetamax </th>
                                    <th> Thetamin </th>
                                    <th> Ttheta </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.windContPitchAngleIECs.map(
                                        windContPitchAngleIEC => 
                                        <tr key = {windContPitchAngleIEC.windContPitchAngleIECId}>
                                             <td> { windContPitchAngleIEC.dthetamax } </td>
                                             <td> { windContPitchAngleIEC.dthetamin } </td>
                                             <td> { windContPitchAngleIEC.kic } </td>
                                             <td> { windContPitchAngleIEC.kiomega } </td>
                                             <td> { windContPitchAngleIEC.kpc } </td>
                                             <td> { windContPitchAngleIEC.kpomega } </td>
                                             <td> { windContPitchAngleIEC.kpx } </td>
                                             <td> { windContPitchAngleIEC.thetamax } </td>
                                             <td> { windContPitchAngleIEC.thetamin } </td>
                                             <td> { windContPitchAngleIEC.ttheta } </td>
                                             <td>
                                                 <button onClick={ () => this.editWindContPitchAngleIEC(windContPitchAngleIEC.windContPitchAngleIECId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteWindContPitchAngleIEC(windContPitchAngleIEC.windContPitchAngleIECId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewWindContPitchAngleIEC(windContPitchAngleIEC.windContPitchAngleIECId)} className="btn btn-info btn-sm">View </button>
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

export default ListWindContPitchAngleIECComponent
