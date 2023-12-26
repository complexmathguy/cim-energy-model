import React, { Component } from 'react'
import WindMechIECService from '../services/WindMechIECService'

class ListWindMechIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                windMechIECs: []
        }
        this.addWindMechIEC = this.addWindMechIEC.bind(this);
        this.editWindMechIEC = this.editWindMechIEC.bind(this);
        this.deleteWindMechIEC = this.deleteWindMechIEC.bind(this);
    }

    deleteWindMechIEC(id){
        WindMechIECService.deleteWindMechIEC(id).then( res => {
            this.setState({windMechIECs: this.state.windMechIECs.filter(windMechIEC => windMechIEC.windMechIECId !== id)});
        });
    }
    viewWindMechIEC(id){
        this.props.history.push(`/view-windMechIEC/${id}`);
    }
    editWindMechIEC(id){
        this.props.history.push(`/add-windMechIEC/${id}`);
    }

    componentDidMount(){
        WindMechIECService.getWindMechIECs().then((res) => {
            this.setState({ windMechIECs: res.data});
        });
    }

    addWindMechIEC(){
        this.props.history.push('/add-windMechIEC/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">WindMechIEC List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addWindMechIEC}> Add WindMechIEC</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Cdrt </th>
                                    <th> Hgen </th>
                                    <th> Hwtr </th>
                                    <th> Kdrt </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.windMechIECs.map(
                                        windMechIEC => 
                                        <tr key = {windMechIEC.windMechIECId}>
                                             <td> { windMechIEC.cdrt } </td>
                                             <td> { windMechIEC.hgen } </td>
                                             <td> { windMechIEC.hwtr } </td>
                                             <td> { windMechIEC.kdrt } </td>
                                             <td>
                                                 <button onClick={ () => this.editWindMechIEC(windMechIEC.windMechIECId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteWindMechIEC(windMechIEC.windMechIECId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewWindMechIEC(windMechIEC.windMechIECId)} className="btn btn-info btn-sm">View </button>
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

export default ListWindMechIECComponent
