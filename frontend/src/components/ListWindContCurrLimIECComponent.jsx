import React, { Component } from 'react'
import WindContCurrLimIECService from '../services/WindContCurrLimIECService'

class ListWindContCurrLimIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                windContCurrLimIECs: []
        }
        this.addWindContCurrLimIEC = this.addWindContCurrLimIEC.bind(this);
        this.editWindContCurrLimIEC = this.editWindContCurrLimIEC.bind(this);
        this.deleteWindContCurrLimIEC = this.deleteWindContCurrLimIEC.bind(this);
    }

    deleteWindContCurrLimIEC(id){
        WindContCurrLimIECService.deleteWindContCurrLimIEC(id).then( res => {
            this.setState({windContCurrLimIECs: this.state.windContCurrLimIECs.filter(windContCurrLimIEC => windContCurrLimIEC.windContCurrLimIECId !== id)});
        });
    }
    viewWindContCurrLimIEC(id){
        this.props.history.push(`/view-windContCurrLimIEC/${id}`);
    }
    editWindContCurrLimIEC(id){
        this.props.history.push(`/add-windContCurrLimIEC/${id}`);
    }

    componentDidMount(){
        WindContCurrLimIECService.getWindContCurrLimIECs().then((res) => {
            this.setState({ windContCurrLimIECs: res.data});
        });
    }

    addWindContCurrLimIEC(){
        this.props.history.push('/add-windContCurrLimIEC/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">WindContCurrLimIEC List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addWindContCurrLimIEC}> Add WindContCurrLimIEC</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Imax </th>
                                    <th> Imaxdip </th>
                                    <th> Mdfslim </th>
                                    <th> Mqpri </th>
                                    <th> Tufilt </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.windContCurrLimIECs.map(
                                        windContCurrLimIEC => 
                                        <tr key = {windContCurrLimIEC.windContCurrLimIECId}>
                                             <td> { windContCurrLimIEC.imax } </td>
                                             <td> { windContCurrLimIEC.imaxdip } </td>
                                             <td> { windContCurrLimIEC.mdfslim } </td>
                                             <td> { windContCurrLimIEC.mqpri } </td>
                                             <td> { windContCurrLimIEC.tufilt } </td>
                                             <td>
                                                 <button onClick={ () => this.editWindContCurrLimIEC(windContCurrLimIEC.windContCurrLimIECId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteWindContCurrLimIEC(windContCurrLimIEC.windContCurrLimIECId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewWindContCurrLimIEC(windContCurrLimIEC.windContCurrLimIECId)} className="btn btn-info btn-sm">View </button>
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

export default ListWindContCurrLimIECComponent
