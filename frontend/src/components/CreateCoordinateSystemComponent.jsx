import React, { Component } from 'react'
import CoordinateSystemService from '../services/CoordinateSystemService';

class CreateCoordinateSystemComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                crsUrn: ''
        }
        this.changecrsUrnHandler = this.changecrsUrnHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            CoordinateSystemService.getCoordinateSystemById(this.state.id).then( (res) =>{
                let coordinateSystem = res.data;
                this.setState({
                    crsUrn: coordinateSystem.crsUrn
                });
            });
        }        
    }
    saveOrUpdateCoordinateSystem = (e) => {
        e.preventDefault();
        let coordinateSystem = {
                coordinateSystemId: this.state.id,
                crsUrn: this.state.crsUrn
            };
        console.log('coordinateSystem => ' + JSON.stringify(coordinateSystem));

        // step 5
        if(this.state.id === '_add'){
            coordinateSystem.coordinateSystemId=''
            CoordinateSystemService.createCoordinateSystem(coordinateSystem).then(res =>{
                this.props.history.push('/coordinateSystems');
            });
        }else{
            CoordinateSystemService.updateCoordinateSystem(coordinateSystem).then( res => {
                this.props.history.push('/coordinateSystems');
            });
        }
    }
    
    changecrsUrnHandler= (event) => {
        this.setState({crsUrn: event.target.value});
    }

    cancel(){
        this.props.history.push('/coordinateSystems');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add CoordinateSystem</h3>
        }else{
            return <h3 className="text-center">Update CoordinateSystem</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> crsUrn: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateCoordinateSystem}>Save</button>
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

export default CreateCoordinateSystemComponent
