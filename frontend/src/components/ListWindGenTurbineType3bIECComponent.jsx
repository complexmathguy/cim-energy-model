import React, { Component } from 'react'
import WindGenTurbineType3bIECService from '../services/WindGenTurbineType3bIECService'

class ListWindGenTurbineType3bIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                windGenTurbineType3bIECs: []
        }
        this.addWindGenTurbineType3bIEC = this.addWindGenTurbineType3bIEC.bind(this);
        this.editWindGenTurbineType3bIEC = this.editWindGenTurbineType3bIEC.bind(this);
        this.deleteWindGenTurbineType3bIEC = this.deleteWindGenTurbineType3bIEC.bind(this);
    }

    deleteWindGenTurbineType3bIEC(id){
        WindGenTurbineType3bIECService.deleteWindGenTurbineType3bIEC(id).then( res => {
            this.setState({windGenTurbineType3bIECs: this.state.windGenTurbineType3bIECs.filter(windGenTurbineType3bIEC => windGenTurbineType3bIEC.windGenTurbineType3bIECId !== id)});
        });
    }
    viewWindGenTurbineType3bIEC(id){
        this.props.history.push(`/view-windGenTurbineType3bIEC/${id}`);
    }
    editWindGenTurbineType3bIEC(id){
        this.props.history.push(`/add-windGenTurbineType3bIEC/${id}`);
    }

    componentDidMount(){
        WindGenTurbineType3bIECService.getWindGenTurbineType3bIECs().then((res) => {
            this.setState({ windGenTurbineType3bIECs: res.data});
        });
    }

    addWindGenTurbineType3bIEC(){
        this.props.history.push('/add-windGenTurbineType3bIEC/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">WindGenTurbineType3bIEC List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addWindGenTurbineType3bIEC}> Add WindGenTurbineType3bIEC</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Fducw </th>
                                    <th> Mwtcwp </th>
                                    <th> Tg </th>
                                    <th> Two </th>
                                    <th> Xs </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.windGenTurbineType3bIECs.map(
                                        windGenTurbineType3bIEC => 
                                        <tr key = {windGenTurbineType3bIEC.windGenTurbineType3bIECId}>
                                             <td> { windGenTurbineType3bIEC.fducw } </td>
                                             <td> { windGenTurbineType3bIEC.mwtcwp } </td>
                                             <td> { windGenTurbineType3bIEC.tg } </td>
                                             <td> { windGenTurbineType3bIEC.two } </td>
                                             <td> { windGenTurbineType3bIEC.xs } </td>
                                             <td>
                                                 <button onClick={ () => this.editWindGenTurbineType3bIEC(windGenTurbineType3bIEC.windGenTurbineType3bIECId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteWindGenTurbineType3bIEC(windGenTurbineType3bIEC.windGenTurbineType3bIECId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewWindGenTurbineType3bIEC(windGenTurbineType3bIEC.windGenTurbineType3bIECId)} className="btn btn-info btn-sm">View </button>
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

export default ListWindGenTurbineType3bIECComponent
