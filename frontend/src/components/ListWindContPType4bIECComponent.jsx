import React, { Component } from 'react'
import WindContPType4bIECService from '../services/WindContPType4bIECService'

class ListWindContPType4bIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                windContPType4bIECs: []
        }
        this.addWindContPType4bIEC = this.addWindContPType4bIEC.bind(this);
        this.editWindContPType4bIEC = this.editWindContPType4bIEC.bind(this);
        this.deleteWindContPType4bIEC = this.deleteWindContPType4bIEC.bind(this);
    }

    deleteWindContPType4bIEC(id){
        WindContPType4bIECService.deleteWindContPType4bIEC(id).then( res => {
            this.setState({windContPType4bIECs: this.state.windContPType4bIECs.filter(windContPType4bIEC => windContPType4bIEC.windContPType4bIECId !== id)});
        });
    }
    viewWindContPType4bIEC(id){
        this.props.history.push(`/view-windContPType4bIEC/${id}`);
    }
    editWindContPType4bIEC(id){
        this.props.history.push(`/add-windContPType4bIEC/${id}`);
    }

    componentDidMount(){
        WindContPType4bIECService.getWindContPType4bIECs().then((res) => {
            this.setState({ windContPType4bIECs: res.data});
        });
    }

    addWindContPType4bIEC(){
        this.props.history.push('/add-windContPType4bIEC/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">WindContPType4bIEC List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addWindContPType4bIEC}> Add WindContPType4bIEC</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Dpmax </th>
                                    <th> Tpaero </th>
                                    <th> Tpord </th>
                                    <th> Tufilt </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.windContPType4bIECs.map(
                                        windContPType4bIEC => 
                                        <tr key = {windContPType4bIEC.windContPType4bIECId}>
                                             <td> { windContPType4bIEC.dpmax } </td>
                                             <td> { windContPType4bIEC.tpaero } </td>
                                             <td> { windContPType4bIEC.tpord } </td>
                                             <td> { windContPType4bIEC.tufilt } </td>
                                             <td>
                                                 <button onClick={ () => this.editWindContPType4bIEC(windContPType4bIEC.windContPType4bIECId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteWindContPType4bIEC(windContPType4bIEC.windContPType4bIECId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewWindContPType4bIEC(windContPType4bIEC.windContPType4bIECId)} className="btn btn-info btn-sm">View </button>
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

export default ListWindContPType4bIECComponent
