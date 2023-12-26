import React, { Component } from 'react'
import WindPlantFreqPcontrolIECService from '../services/WindPlantFreqPcontrolIECService'

class ListWindPlantFreqPcontrolIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                windPlantFreqPcontrolIECs: []
        }
        this.addWindPlantFreqPcontrolIEC = this.addWindPlantFreqPcontrolIEC.bind(this);
        this.editWindPlantFreqPcontrolIEC = this.editWindPlantFreqPcontrolIEC.bind(this);
        this.deleteWindPlantFreqPcontrolIEC = this.deleteWindPlantFreqPcontrolIEC.bind(this);
    }

    deleteWindPlantFreqPcontrolIEC(id){
        WindPlantFreqPcontrolIECService.deleteWindPlantFreqPcontrolIEC(id).then( res => {
            this.setState({windPlantFreqPcontrolIECs: this.state.windPlantFreqPcontrolIECs.filter(windPlantFreqPcontrolIEC => windPlantFreqPcontrolIEC.windPlantFreqPcontrolIECId !== id)});
        });
    }
    viewWindPlantFreqPcontrolIEC(id){
        this.props.history.push(`/view-windPlantFreqPcontrolIEC/${id}`);
    }
    editWindPlantFreqPcontrolIEC(id){
        this.props.history.push(`/add-windPlantFreqPcontrolIEC/${id}`);
    }

    componentDidMount(){
        WindPlantFreqPcontrolIECService.getWindPlantFreqPcontrolIECs().then((res) => {
            this.setState({ windPlantFreqPcontrolIECs: res.data});
        });
    }

    addWindPlantFreqPcontrolIEC(){
        this.props.history.push('/add-windPlantFreqPcontrolIEC/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">WindPlantFreqPcontrolIEC List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addWindPlantFreqPcontrolIEC}> Add WindPlantFreqPcontrolIEC</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Dprefmax </th>
                                    <th> Dprefmin </th>
                                    <th> Kiwpp </th>
                                    <th> Kpwpp </th>
                                    <th> Prefmax </th>
                                    <th> Prefmin </th>
                                    <th> Tpft </th>
                                    <th> Tpfv </th>
                                    <th> Twpffilt </th>
                                    <th> Twppfilt </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.windPlantFreqPcontrolIECs.map(
                                        windPlantFreqPcontrolIEC => 
                                        <tr key = {windPlantFreqPcontrolIEC.windPlantFreqPcontrolIECId}>
                                             <td> { windPlantFreqPcontrolIEC.dprefmax } </td>
                                             <td> { windPlantFreqPcontrolIEC.dprefmin } </td>
                                             <td> { windPlantFreqPcontrolIEC.kiwpp } </td>
                                             <td> { windPlantFreqPcontrolIEC.kpwpp } </td>
                                             <td> { windPlantFreqPcontrolIEC.prefmax } </td>
                                             <td> { windPlantFreqPcontrolIEC.prefmin } </td>
                                             <td> { windPlantFreqPcontrolIEC.tpft } </td>
                                             <td> { windPlantFreqPcontrolIEC.tpfv } </td>
                                             <td> { windPlantFreqPcontrolIEC.twpffilt } </td>
                                             <td> { windPlantFreqPcontrolIEC.twppfilt } </td>
                                             <td>
                                                 <button onClick={ () => this.editWindPlantFreqPcontrolIEC(windPlantFreqPcontrolIEC.windPlantFreqPcontrolIECId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteWindPlantFreqPcontrolIEC(windPlantFreqPcontrolIEC.windPlantFreqPcontrolIECId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewWindPlantFreqPcontrolIEC(windPlantFreqPcontrolIEC.windPlantFreqPcontrolIECId)} className="btn btn-info btn-sm">View </button>
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

export default ListWindPlantFreqPcontrolIECComponent
