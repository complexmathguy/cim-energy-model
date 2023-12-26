import React, { Component } from 'react'
import WindGenType4IECService from '../services/WindGenType4IECService'

class ListWindGenType4IECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                windGenType4IECs: []
        }
        this.addWindGenType4IEC = this.addWindGenType4IEC.bind(this);
        this.editWindGenType4IEC = this.editWindGenType4IEC.bind(this);
        this.deleteWindGenType4IEC = this.deleteWindGenType4IEC.bind(this);
    }

    deleteWindGenType4IEC(id){
        WindGenType4IECService.deleteWindGenType4IEC(id).then( res => {
            this.setState({windGenType4IECs: this.state.windGenType4IECs.filter(windGenType4IEC => windGenType4IEC.windGenType4IECId !== id)});
        });
    }
    viewWindGenType4IEC(id){
        this.props.history.push(`/view-windGenType4IEC/${id}`);
    }
    editWindGenType4IEC(id){
        this.props.history.push(`/add-windGenType4IEC/${id}`);
    }

    componentDidMount(){
        WindGenType4IECService.getWindGenType4IECs().then((res) => {
            this.setState({ windGenType4IECs: res.data});
        });
    }

    addWindGenType4IEC(){
        this.props.history.push('/add-windGenType4IEC/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">WindGenType4IEC List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addWindGenType4IEC}> Add WindGenType4IEC</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Dipmax </th>
                                    <th> Diqmax </th>
                                    <th> Diqmin </th>
                                    <th> Tg </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.windGenType4IECs.map(
                                        windGenType4IEC => 
                                        <tr key = {windGenType4IEC.windGenType4IECId}>
                                             <td> { windGenType4IEC.dipmax } </td>
                                             <td> { windGenType4IEC.diqmax } </td>
                                             <td> { windGenType4IEC.diqmin } </td>
                                             <td> { windGenType4IEC.tg } </td>
                                             <td>
                                                 <button onClick={ () => this.editWindGenType4IEC(windGenType4IEC.windGenType4IECId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteWindGenType4IEC(windGenType4IEC.windGenType4IECId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewWindGenType4IEC(windGenType4IEC.windGenType4IECId)} className="btn btn-info btn-sm">View </button>
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

export default ListWindGenType4IECComponent
