import React, { Component } from 'react'
import WindPlantReactiveControlIECService from '../services/WindPlantReactiveControlIECService'

class ListWindPlantReactiveControlIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                windPlantReactiveControlIECs: []
        }
        this.addWindPlantReactiveControlIEC = this.addWindPlantReactiveControlIEC.bind(this);
        this.editWindPlantReactiveControlIEC = this.editWindPlantReactiveControlIEC.bind(this);
        this.deleteWindPlantReactiveControlIEC = this.deleteWindPlantReactiveControlIEC.bind(this);
    }

    deleteWindPlantReactiveControlIEC(id){
        WindPlantReactiveControlIECService.deleteWindPlantReactiveControlIEC(id).then( res => {
            this.setState({windPlantReactiveControlIECs: this.state.windPlantReactiveControlIECs.filter(windPlantReactiveControlIEC => windPlantReactiveControlIEC.windPlantReactiveControlIECId !== id)});
        });
    }
    viewWindPlantReactiveControlIEC(id){
        this.props.history.push(`/view-windPlantReactiveControlIEC/${id}`);
    }
    editWindPlantReactiveControlIEC(id){
        this.props.history.push(`/add-windPlantReactiveControlIEC/${id}`);
    }

    componentDidMount(){
        WindPlantReactiveControlIECService.getWindPlantReactiveControlIECs().then((res) => {
            this.setState({ windPlantReactiveControlIECs: res.data});
        });
    }

    addWindPlantReactiveControlIEC(){
        this.props.history.push('/add-windPlantReactiveControlIEC/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">WindPlantReactiveControlIEC List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addWindPlantReactiveControlIEC}> Add WindPlantReactiveControlIEC</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Kiwpx </th>
                                    <th> Kpwpx </th>
                                    <th> Kwpqu </th>
                                    <th> Mwppf </th>
                                    <th> Mwpu </th>
                                    <th> Twppfilt </th>
                                    <th> Twpqfilt </th>
                                    <th> Twpufilt </th>
                                    <th> Txft </th>
                                    <th> Txfv </th>
                                    <th> Uwpqdip </th>
                                    <th> Xrefmax </th>
                                    <th> Xrefmin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.windPlantReactiveControlIECs.map(
                                        windPlantReactiveControlIEC => 
                                        <tr key = {windPlantReactiveControlIEC.windPlantReactiveControlIECId}>
                                             <td> { windPlantReactiveControlIEC.kiwpx } </td>
                                             <td> { windPlantReactiveControlIEC.kpwpx } </td>
                                             <td> { windPlantReactiveControlIEC.kwpqu } </td>
                                             <td> { windPlantReactiveControlIEC.mwppf } </td>
                                             <td> { windPlantReactiveControlIEC.mwpu } </td>
                                             <td> { windPlantReactiveControlIEC.twppfilt } </td>
                                             <td> { windPlantReactiveControlIEC.twpqfilt } </td>
                                             <td> { windPlantReactiveControlIEC.twpufilt } </td>
                                             <td> { windPlantReactiveControlIEC.txft } </td>
                                             <td> { windPlantReactiveControlIEC.txfv } </td>
                                             <td> { windPlantReactiveControlIEC.uwpqdip } </td>
                                             <td> { windPlantReactiveControlIEC.xrefmax } </td>
                                             <td> { windPlantReactiveControlIEC.xrefmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editWindPlantReactiveControlIEC(windPlantReactiveControlIEC.windPlantReactiveControlIECId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteWindPlantReactiveControlIEC(windPlantReactiveControlIEC.windPlantReactiveControlIECId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewWindPlantReactiveControlIEC(windPlantReactiveControlIEC.windPlantReactiveControlIECId)} className="btn btn-info btn-sm">View </button>
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

export default ListWindPlantReactiveControlIECComponent
