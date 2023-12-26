import React, { Component } from 'react'
import WindContPType3IECService from '../services/WindContPType3IECService'

class ListWindContPType3IECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                windContPType3IECs: []
        }
        this.addWindContPType3IEC = this.addWindContPType3IEC.bind(this);
        this.editWindContPType3IEC = this.editWindContPType3IEC.bind(this);
        this.deleteWindContPType3IEC = this.deleteWindContPType3IEC.bind(this);
    }

    deleteWindContPType3IEC(id){
        WindContPType3IECService.deleteWindContPType3IEC(id).then( res => {
            this.setState({windContPType3IECs: this.state.windContPType3IECs.filter(windContPType3IEC => windContPType3IEC.windContPType3IECId !== id)});
        });
    }
    viewWindContPType3IEC(id){
        this.props.history.push(`/view-windContPType3IEC/${id}`);
    }
    editWindContPType3IEC(id){
        this.props.history.push(`/add-windContPType3IEC/${id}`);
    }

    componentDidMount(){
        WindContPType3IECService.getWindContPType3IECs().then((res) => {
            this.setState({ windContPType3IECs: res.data});
        });
    }

    addWindContPType3IEC(){
        this.props.history.push('/add-windContPType3IEC/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">WindContPType3IEC List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addWindContPType3IEC}> Add WindContPType3IEC</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Dpmax </th>
                                    <th> Dtrisemaxlvrt </th>
                                    <th> Kdtd </th>
                                    <th> Kip </th>
                                    <th> Kpp </th>
                                    <th> Mplvrt </th>
                                    <th> Omegaoffset </th>
                                    <th> Pdtdmax </th>
                                    <th> Rramp </th>
                                    <th> Tdvs </th>
                                    <th> Temin </th>
                                    <th> Tomegafilt </th>
                                    <th> Tpfilt </th>
                                    <th> Tpord </th>
                                    <th> Tufilt </th>
                                    <th> Tuscale </th>
                                    <th> Twref </th>
                                    <th> Udvs </th>
                                    <th> Updip </th>
                                    <th> Wdtd </th>
                                    <th> Zeta </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.windContPType3IECs.map(
                                        windContPType3IEC => 
                                        <tr key = {windContPType3IEC.windContPType3IECId}>
                                             <td> { windContPType3IEC.dpmax } </td>
                                             <td> { windContPType3IEC.dtrisemaxlvrt } </td>
                                             <td> { windContPType3IEC.kdtd } </td>
                                             <td> { windContPType3IEC.kip } </td>
                                             <td> { windContPType3IEC.kpp } </td>
                                             <td> { windContPType3IEC.mplvrt } </td>
                                             <td> { windContPType3IEC.omegaoffset } </td>
                                             <td> { windContPType3IEC.pdtdmax } </td>
                                             <td> { windContPType3IEC.rramp } </td>
                                             <td> { windContPType3IEC.tdvs } </td>
                                             <td> { windContPType3IEC.temin } </td>
                                             <td> { windContPType3IEC.tomegafilt } </td>
                                             <td> { windContPType3IEC.tpfilt } </td>
                                             <td> { windContPType3IEC.tpord } </td>
                                             <td> { windContPType3IEC.tufilt } </td>
                                             <td> { windContPType3IEC.tuscale } </td>
                                             <td> { windContPType3IEC.twref } </td>
                                             <td> { windContPType3IEC.udvs } </td>
                                             <td> { windContPType3IEC.updip } </td>
                                             <td> { windContPType3IEC.wdtd } </td>
                                             <td> { windContPType3IEC.zeta } </td>
                                             <td>
                                                 <button onClick={ () => this.editWindContPType3IEC(windContPType3IEC.windContPType3IECId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteWindContPType3IEC(windContPType3IEC.windContPType3IECId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewWindContPType3IEC(windContPType3IEC.windContPType3IECId)} className="btn btn-info btn-sm">View </button>
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

export default ListWindContPType3IECComponent
