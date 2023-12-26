import React, { Component } from 'react'
import WindContPType4aIECService from '../services/WindContPType4aIECService'

class ListWindContPType4aIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                windContPType4aIECs: []
        }
        this.addWindContPType4aIEC = this.addWindContPType4aIEC.bind(this);
        this.editWindContPType4aIEC = this.editWindContPType4aIEC.bind(this);
        this.deleteWindContPType4aIEC = this.deleteWindContPType4aIEC.bind(this);
    }

    deleteWindContPType4aIEC(id){
        WindContPType4aIECService.deleteWindContPType4aIEC(id).then( res => {
            this.setState({windContPType4aIECs: this.state.windContPType4aIECs.filter(windContPType4aIEC => windContPType4aIEC.windContPType4aIECId !== id)});
        });
    }
    viewWindContPType4aIEC(id){
        this.props.history.push(`/view-windContPType4aIEC/${id}`);
    }
    editWindContPType4aIEC(id){
        this.props.history.push(`/add-windContPType4aIEC/${id}`);
    }

    componentDidMount(){
        WindContPType4aIECService.getWindContPType4aIECs().then((res) => {
            this.setState({ windContPType4aIECs: res.data});
        });
    }

    addWindContPType4aIEC(){
        this.props.history.push('/add-windContPType4aIEC/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">WindContPType4aIEC List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addWindContPType4aIEC}> Add WindContPType4aIEC</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Dpmax </th>
                                    <th> Tpord </th>
                                    <th> Tufilt </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.windContPType4aIECs.map(
                                        windContPType4aIEC => 
                                        <tr key = {windContPType4aIEC.windContPType4aIECId}>
                                             <td> { windContPType4aIEC.dpmax } </td>
                                             <td> { windContPType4aIEC.tpord } </td>
                                             <td> { windContPType4aIEC.tufilt } </td>
                                             <td>
                                                 <button onClick={ () => this.editWindContPType4aIEC(windContPType4aIEC.windContPType4aIECId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteWindContPType4aIEC(windContPType4aIEC.windContPType4aIECId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewWindContPType4aIEC(windContPType4aIEC.windContPType4aIECId)} className="btn btn-info btn-sm">View </button>
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

export default ListWindContPType4aIECComponent
