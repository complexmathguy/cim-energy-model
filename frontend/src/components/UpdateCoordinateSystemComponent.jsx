import React, { Component } from 'react'
import CoordinateSystemService from '../services/CoordinateSystemService';

class UpdateCoordinateSystemComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                crsUrn: ''
        }
        this.updateCoordinateSystem = this.updateCoordinateSystem.bind(this);

        this.changecrsUrnHandler = this.changecrsUrnHandler.bind(this);
    }

    componentDidMount(){
        CoordinateSystemService.getCoordinateSystemById(this.state.id).then( (res) =>{
            let coordinateSystem = res.data;
            this.setState({
                crsUrn: coordinateSystem.crsUrn
            });
        });
    }

    updateCoordinateSystem = (e) => {
        e.preventDefault();
        let coordinateSystem = {
            coordinateSystemId: this.state.id,
            crsUrn: this.state.crsUrn
        };
        console.log('coordinateSystem => ' + JSON.stringify(coordinateSystem));
        console.log('id => ' + JSON.stringify(this.state.id));
        CoordinateSystemService.updateCoordinateSystem(coordinateSystem).then( res => {
            this.props.history.push('/coordinateSystems');
        });
    }

    changecrsUrnHandler= (event) => {
        this.setState({crsUrn: event.target.value});
    }

    cancel(){
        this.props.history.push('/coordinateSystems');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update CoordinateSystem</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> crsUrn: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateCoordinateSystem}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateCoordinateSystemComponent
