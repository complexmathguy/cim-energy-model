import React, { Component } from 'react'
import ExternalNetworkInjectionService from '../services/ExternalNetworkInjectionService'

class ListExternalNetworkInjectionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                externalNetworkInjections: []
        }
        this.addExternalNetworkInjection = this.addExternalNetworkInjection.bind(this);
        this.editExternalNetworkInjection = this.editExternalNetworkInjection.bind(this);
        this.deleteExternalNetworkInjection = this.deleteExternalNetworkInjection.bind(this);
    }

    deleteExternalNetworkInjection(id){
        ExternalNetworkInjectionService.deleteExternalNetworkInjection(id).then( res => {
            this.setState({externalNetworkInjections: this.state.externalNetworkInjections.filter(externalNetworkInjection => externalNetworkInjection.externalNetworkInjectionId !== id)});
        });
    }
    viewExternalNetworkInjection(id){
        this.props.history.push(`/view-externalNetworkInjection/${id}`);
    }
    editExternalNetworkInjection(id){
        this.props.history.push(`/add-externalNetworkInjection/${id}`);
    }

    componentDidMount(){
        ExternalNetworkInjectionService.getExternalNetworkInjections().then((res) => {
            this.setState({ externalNetworkInjections: res.data});
        });
    }

    addExternalNetworkInjection(){
        this.props.history.push('/add-externalNetworkInjection/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExternalNetworkInjection List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExternalNetworkInjection}> Add ExternalNetworkInjection</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> GovernorSCD </th>
                                    <th> IkSecond </th>
                                    <th> MaxInitialSymShCCurrent </th>
                                    <th> MaxP </th>
                                    <th> MaxQ </th>
                                    <th> MaxR0ToX0Ratio </th>
                                    <th> MaxR1ToX1Ratio </th>
                                    <th> MaxZ0ToZ1Ratio </th>
                                    <th> MinInitialSymShCCurrent </th>
                                    <th> MinP </th>
                                    <th> MinQ </th>
                                    <th> MinR0ToX0Ratio </th>
                                    <th> MinR1ToX1Ratio </th>
                                    <th> MinZ0ToZ1Ratio </th>
                                    <th> VoltageFactor </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.externalNetworkInjections.map(
                                        externalNetworkInjection => 
                                        <tr key = {externalNetworkInjection.externalNetworkInjectionId}>
                                             <td> { externalNetworkInjection.governorSCD } </td>
                                             <td> { externalNetworkInjection.ikSecond } </td>
                                             <td> { externalNetworkInjection.maxInitialSymShCCurrent } </td>
                                             <td> { externalNetworkInjection.maxP } </td>
                                             <td> { externalNetworkInjection.maxQ } </td>
                                             <td> { externalNetworkInjection.maxR0ToX0Ratio } </td>
                                             <td> { externalNetworkInjection.maxR1ToX1Ratio } </td>
                                             <td> { externalNetworkInjection.maxZ0ToZ1Ratio } </td>
                                             <td> { externalNetworkInjection.minInitialSymShCCurrent } </td>
                                             <td> { externalNetworkInjection.minP } </td>
                                             <td> { externalNetworkInjection.minQ } </td>
                                             <td> { externalNetworkInjection.minR0ToX0Ratio } </td>
                                             <td> { externalNetworkInjection.minR1ToX1Ratio } </td>
                                             <td> { externalNetworkInjection.minZ0ToZ1Ratio } </td>
                                             <td> { externalNetworkInjection.voltageFactor } </td>
                                             <td>
                                                 <button onClick={ () => this.editExternalNetworkInjection(externalNetworkInjection.externalNetworkInjectionId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExternalNetworkInjection(externalNetworkInjection.externalNetworkInjectionId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExternalNetworkInjection(externalNetworkInjection.externalNetworkInjectionId)} className="btn btn-info btn-sm">View </button>
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

export default ListExternalNetworkInjectionComponent
