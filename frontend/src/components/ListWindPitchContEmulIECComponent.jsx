import React, { Component } from 'react'
import WindPitchContEmulIECService from '../services/WindPitchContEmulIECService'

class ListWindPitchContEmulIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                windPitchContEmulIECs: []
        }
        this.addWindPitchContEmulIEC = this.addWindPitchContEmulIEC.bind(this);
        this.editWindPitchContEmulIEC = this.editWindPitchContEmulIEC.bind(this);
        this.deleteWindPitchContEmulIEC = this.deleteWindPitchContEmulIEC.bind(this);
    }

    deleteWindPitchContEmulIEC(id){
        WindPitchContEmulIECService.deleteWindPitchContEmulIEC(id).then( res => {
            this.setState({windPitchContEmulIECs: this.state.windPitchContEmulIECs.filter(windPitchContEmulIEC => windPitchContEmulIEC.windPitchContEmulIECId !== id)});
        });
    }
    viewWindPitchContEmulIEC(id){
        this.props.history.push(`/view-windPitchContEmulIEC/${id}`);
    }
    editWindPitchContEmulIEC(id){
        this.props.history.push(`/add-windPitchContEmulIEC/${id}`);
    }

    componentDidMount(){
        WindPitchContEmulIECService.getWindPitchContEmulIECs().then((res) => {
            this.setState({ windPitchContEmulIECs: res.data});
        });
    }

    addWindPitchContEmulIEC(){
        this.props.history.push('/add-windPitchContEmulIEC/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">WindPitchContEmulIEC List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addWindPitchContEmulIEC}> Add WindPitchContEmulIEC</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Kdroop </th>
                                    <th> Kipce </th>
                                    <th> Komegaaero </th>
                                    <th> Kppce </th>
                                    <th> Omegaref </th>
                                    <th> Pimax </th>
                                    <th> Pimin </th>
                                    <th> T1 </th>
                                    <th> T2 </th>
                                    <th> Tpe </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.windPitchContEmulIECs.map(
                                        windPitchContEmulIEC => 
                                        <tr key = {windPitchContEmulIEC.windPitchContEmulIECId}>
                                             <td> { windPitchContEmulIEC.kdroop } </td>
                                             <td> { windPitchContEmulIEC.kipce } </td>
                                             <td> { windPitchContEmulIEC.komegaaero } </td>
                                             <td> { windPitchContEmulIEC.kppce } </td>
                                             <td> { windPitchContEmulIEC.omegaref } </td>
                                             <td> { windPitchContEmulIEC.pimax } </td>
                                             <td> { windPitchContEmulIEC.pimin } </td>
                                             <td> { windPitchContEmulIEC.t1 } </td>
                                             <td> { windPitchContEmulIEC.t2 } </td>
                                             <td> { windPitchContEmulIEC.tpe } </td>
                                             <td>
                                                 <button onClick={ () => this.editWindPitchContEmulIEC(windPitchContEmulIEC.windPitchContEmulIECId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteWindPitchContEmulIEC(windPitchContEmulIEC.windPitchContEmulIECId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewWindPitchContEmulIEC(windPitchContEmulIEC.windPitchContEmulIECId)} className="btn btn-info btn-sm">View </button>
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

export default ListWindPitchContEmulIECComponent
