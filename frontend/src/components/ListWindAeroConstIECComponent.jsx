import React, { Component } from 'react'
import WindAeroConstIECService from '../services/WindAeroConstIECService'

class ListWindAeroConstIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                windAeroConstIECs: []
        }
        this.addWindAeroConstIEC = this.addWindAeroConstIEC.bind(this);
        this.editWindAeroConstIEC = this.editWindAeroConstIEC.bind(this);
        this.deleteWindAeroConstIEC = this.deleteWindAeroConstIEC.bind(this);
    }

    deleteWindAeroConstIEC(id){
        WindAeroConstIECService.deleteWindAeroConstIEC(id).then( res => {
            this.setState({windAeroConstIECs: this.state.windAeroConstIECs.filter(windAeroConstIEC => windAeroConstIEC.windAeroConstIECId !== id)});
        });
    }
    viewWindAeroConstIEC(id){
        this.props.history.push(`/view-windAeroConstIEC/${id}`);
    }
    editWindAeroConstIEC(id){
        this.props.history.push(`/add-windAeroConstIEC/${id}`);
    }

    componentDidMount(){
        WindAeroConstIECService.getWindAeroConstIECs().then((res) => {
            this.setState({ windAeroConstIECs: res.data});
        });
    }

    addWindAeroConstIEC(){
        this.props.history.push('/add-windAeroConstIEC/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">WindAeroConstIEC List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addWindAeroConstIEC}> Add WindAeroConstIEC</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.windAeroConstIECs.map(
                                        windAeroConstIEC => 
                                        <tr key = {windAeroConstIEC.windAeroConstIECId}>
                                             <td>
                                                 <button onClick={ () => this.editWindAeroConstIEC(windAeroConstIEC.windAeroConstIECId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteWindAeroConstIEC(windAeroConstIEC.windAeroConstIECId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewWindAeroConstIEC(windAeroConstIEC.windAeroConstIECId)} className="btn btn-info btn-sm">View </button>
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

export default ListWindAeroConstIECComponent
