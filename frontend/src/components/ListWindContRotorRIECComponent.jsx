import React, { Component } from 'react'
import WindContRotorRIECService from '../services/WindContRotorRIECService'

class ListWindContRotorRIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                windContRotorRIECs: []
        }
        this.addWindContRotorRIEC = this.addWindContRotorRIEC.bind(this);
        this.editWindContRotorRIEC = this.editWindContRotorRIEC.bind(this);
        this.deleteWindContRotorRIEC = this.deleteWindContRotorRIEC.bind(this);
    }

    deleteWindContRotorRIEC(id){
        WindContRotorRIECService.deleteWindContRotorRIEC(id).then( res => {
            this.setState({windContRotorRIECs: this.state.windContRotorRIECs.filter(windContRotorRIEC => windContRotorRIEC.windContRotorRIECId !== id)});
        });
    }
    viewWindContRotorRIEC(id){
        this.props.history.push(`/view-windContRotorRIEC/${id}`);
    }
    editWindContRotorRIEC(id){
        this.props.history.push(`/add-windContRotorRIEC/${id}`);
    }

    componentDidMount(){
        WindContRotorRIECService.getWindContRotorRIECs().then((res) => {
            this.setState({ windContRotorRIECs: res.data});
        });
    }

    addWindContRotorRIEC(){
        this.props.history.push('/add-windContRotorRIEC/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">WindContRotorRIEC List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addWindContRotorRIEC}> Add WindContRotorRIEC</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Kirr </th>
                                    <th> Komegafilt </th>
                                    <th> Kpfilt </th>
                                    <th> Kprr </th>
                                    <th> Rmax </th>
                                    <th> Rmin </th>
                                    <th> Tomegafilt </th>
                                    <th> Tpfilt </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.windContRotorRIECs.map(
                                        windContRotorRIEC => 
                                        <tr key = {windContRotorRIEC.windContRotorRIECId}>
                                             <td> { windContRotorRIEC.kirr } </td>
                                             <td> { windContRotorRIEC.komegafilt } </td>
                                             <td> { windContRotorRIEC.kpfilt } </td>
                                             <td> { windContRotorRIEC.kprr } </td>
                                             <td> { windContRotorRIEC.rmax } </td>
                                             <td> { windContRotorRIEC.rmin } </td>
                                             <td> { windContRotorRIEC.tomegafilt } </td>
                                             <td> { windContRotorRIEC.tpfilt } </td>
                                             <td>
                                                 <button onClick={ () => this.editWindContRotorRIEC(windContRotorRIEC.windContRotorRIECId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteWindContRotorRIEC(windContRotorRIEC.windContRotorRIECId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewWindContRotorRIEC(windContRotorRIEC.windContRotorRIECId)} className="btn btn-info btn-sm">View </button>
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

export default ListWindContRotorRIECComponent
